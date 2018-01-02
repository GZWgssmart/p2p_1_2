package top.zzh.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.zzh.bean.*;
import top.zzh.common.*;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.message.GetPhoneMessage;
import top.zzh.query.LoginLogQuery;
import top.zzh.service.LoginLogService;
import top.zzh.service.RecommendService;
import top.zzh.service.RoleService;
import top.zzh.service.UserService;
import top.zzh.vo.ControllerStatusVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
@Controller
@RequestMapping("/luser")
public class LUserController {

    private Logger logger = LoggerFactory.getLogger(LUserController.class);
    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RecommendService recommendService;

    private  LoginLogQuery loginLogQuery;


    @GetMapping("login_page")
    public String showLogin() {
        return "/user/login";
    }

    @PostMapping("login")
    @ResponseBody
    public ControllerStatusVO login(HttpSession session, String name, HttpServletRequest request, String password, String code) {
        Object obj = session.getAttribute(Constants.CODE_IN_SESSION);
        ControllerStatusVO statusVO = null;
        if (obj != null) {
            String checkCode = (String) obj;
            if (checkCode.equalsIgnoreCase(code)) {

                Object userObj = session.getAttribute(Constants.USER_IN_SESSION);
                if (userObj == null) {
                    Subject subject = SecurityUtils.getSubject();
                    try {
                        subject.login(new UsernamePasswordToken(name, password));
                        Session sessionShiro = subject.getSession();//获取用户会话信息
                        sessionShiro.setAttribute(Constants.USER_IN_SESSION, name);
                        long userid = loginLogService.getByName(name);
                        LoginLog log = new LoginLog();
                        log.setUserId(userid);
                        log.setLoginIp(request.getRemoteHost());
                        loginLogService.save(log);
                        sessionShiro.setAttribute(Constants.USER_ID_SESSION,userid);

                        statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_SUCCESS);
                        session.setAttribute("userObj",userObj);
                    } catch (AuthenticationException e) {
                        statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_FAIL);
                    }

                } else {
                    statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_ALREADY_LOGIN);
                }
            } else {
                statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_ERROR_CODE);
            }
        }

        return statusVO;
    }


    @GetMapping("userindex")
    public String userLogin(HttpSession session,HttpServletRequest request) {
        String name= (String) session.getAttribute(Constants.USER_IN_SESSION);
        String time=loginLogService.getByloginTime(name);
        User user=userService.getByface(name);
        request.setAttribute("time",time);
        request.setAttribute("face",user.getFace());
        return "/user/userindex";
    }


    @PostMapping("gainCode")
    @ResponseBody
    public Integer gainCode(String phone, HttpServletRequest request) {
        System.out.println(phone);
        String result = GetPhoneMessage.getResult(phone);
        return Integer.parseInt(result);
    }

    @RequestMapping("forgetPassword")
    @ResponseBody
    public ControllerStatusVO forgetPassword(HttpServletRequest request, String phone, HttpSession session) {
        System.out.println(phone);
        ControllerStatusVO statusVO = null;
        User user = userService.getByPhone(phone);

        if (user == null) {
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_ERROR_EXIST);
            return statusVO;
        }

        List<String> stringList = roleService.listRoles(user.getUname());
        if (stringList == null) {
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_ERROR_EXIST_POWER);
            return statusVO;
        }

        if (user != null && user.getState() == 1 && stringList.size() != 0) {
            LoginLog log = new LoginLog();
            log.setUserId(user.getUid());
            log.setLoginIp(request.getRemoteHost());
            loginLogService.save(log);
            session.setAttribute(Constants.USER_IN_SESSION, user.getUname());
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_SUCCESS);
        } else {
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_ERROR_EXIST_POWER);
        }

        return statusVO;
    }

    @GetMapping("forgetPasswordView")
    public String forgetPasswordView() {

        return "/user/forgetPassword";
    }

    @GetMapping("register")
    public String register() {

        return "/user/register";
    }


    @RequestMapping("checkPhone")
    @ResponseBody
    public ControllerStatusVO checkPhone(String phone) {
        ControllerStatusVO statusVO = null;
        User user = userService.getByPhone(phone);
        if (user != null) {
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_ERROR_ALREADYEXIST);
        }

        return statusVO;
    }

    @PostMapping("uploadHeader")
    public String uploadHeader(MultipartFile header, HttpServletRequest request, HttpSession session){
        ControllerStatusVO statusVO=null;

        try {
            copyInputStreamToFile(header.getInputStream(),new File(PathUtils.uploadDir(request)+"/"+header.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String face="static/uploads/"+header.getOriginalFilename();

        userService.saveHeader(face, (String) session.getAttribute(Constants.USER_IN_SESSION));
        String time=loginLogService.getByloginTime((String) session.getAttribute(Constants.USER_IN_SESSION));
        request.setAttribute("face",face);
        request.setAttribute("time",time);

        return  "user/userindex";
    }

    @PostMapping("registerSave")
    @ResponseBody
    public ControllerStatusVO registerSave(User user, String userCode) {
        ControllerStatusVO statusVO = null;
        if (userCode != null && !userCode.equals("")) {
            User userToRecommend = (User) recommendService.getByTzm(userCode);
            if (userToRecommend.getUid() == null || userToRecommend.getUname() == null) {
                statusVO = ControllerStatusVO.status(ControllerStatusEnum.TZM_FIND_FAIL);
                return statusVO;
            }
            //推荐保存
            Recommend recommend = new Recommend();
            recommend.setTid(userToRecommend.getUid());
            recommend.setTname(userToRecommend.getRname());
            recommend.setUid(user.getUid());
            recommend.setRname(user.getRname());
            recommendService.save(recommend);
        }
        String pwd = EncryptUtils.md5(user.getUpwd());
        user.setUpwd(pwd);
        // 推荐码的生成
        String tzmCode = CheckCodeUtils.tzmCode();
        int exit = 1;
        while (exit == 1) {
            //不存在：0  存在：1
            int isExit = recommendService.countTzm(tzmCode);
            if (isExit == 1) {
                tzmCode = CheckCodeUtils.tzmCode();
            } else if (isExit == 0) {
                exit = 0;
                user.setTzm(tzmCode);
            }
        }
        userService.register(user);
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_SUCCESS);
        System.out.println("新增的id为：" + user.getUid());
        UserRole userRole = new UserRole();
        userRole.setRoleId(3);
        userRole.setUserId(Math.toIntExact(user.getUid()));
        roleService.save(userRole);

        return statusVO;
    }


    @GetMapping("registerSuccess")
    public String registerSuccess() {

        return "/user/registerSuccess";
    }


    @RequestMapping("loginlog")
    public String loginlogpage(){
        return "manager/loginlog";
    }



    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int pageIndex, int pageSize) {
        logger.info("登录日志+条件查询");
        return loginLogService.listPagerCriteria(pageIndex, pageSize,loginLogQuery);
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        String name=(String)session.getAttribute(Constants.USER_IN_SESSION);
        long userid=loginLogService.getByName(name);
        loginLogService.updateByUserId(userid);
        session.invalidate();
        return "user/login";
    }

    public LoginLogQuery getLoginLogQuery() {
        return loginLogQuery;
    }

    public void setLoginLogQuery(LoginLogQuery loginLogQuery) {
        this.loginLogQuery = loginLogQuery;
    }

    @RequestMapping("zpwdUpdate1")
    public String zpwdUpdate(HttpSession session){
        String uname=(String)session.getAttribute(Constants.USER_IN_SESSION);
        String zpwd=userService.getByZpwd(uname);
        if(zpwd==null){
            return "user/zpwdUpdate1";
        }
        if(zpwd.equals("")){
            return "user/zpwdUpdate1";
        }
        if(!zpwd.equals("")){
            return "user/zpwdUpdate2";
        }
        return "";
    }

    @PostMapping("updateZpwd")
    public String updateZpwd(HttpServletRequest request,String zpwd,HttpSession session){
        String uname= (String) session.getAttribute(Constants.USER_IN_SESSION);
        userService.updateZpwd(uname,EncryptUtils.md5(zpwd));
        request.setAttribute("exist","恭喜您，修改支付密码成功！");
        return  "user/zpwdUpdate1";
    }

    @PostMapping("updateZpwd2")
    public String updateZpwd2(HttpServletRequest request,HttpSession session,String zpwd,String xpwd){
        String uname=(String)session.getAttribute(Constants.USER_IN_SESSION);
        String zpd=userService.getByZpwd(uname);
        String pd=EncryptUtils.md5(zpwd);
        if(!pd.equals(zpd)){
            request.setAttribute("check","原支付密码输入错误！");
            return  "user/zpwdUpdate2";
        }
        if(pd.equals(zpd)){
            userService.updateZpwd(uname,EncryptUtils.md5(xpwd));
            request.setAttribute("exist","恭喜您，修改支付密码成功！");
            return  "user/zpwdUpdate2";
        }
        return "";
    }

    @RequestMapping("upwdUpdateView")
    public String upwdUpdateView(){

        return  "user/upwdUpdate";
    }

    @PostMapping("upwdUpdate")
    public String upwdUpdate(HttpServletRequest request,HttpSession session,String upwd,String xupwd){
        Long uid=(Long)session.getAttribute(Constants.USER_ID_SESSION);
        User user= (User) userService.getById(uid);
        String upd=EncryptUtils.md5(upwd);
        if(upd.equals(user.getUpwd())){
            userService.updateUpwd(uid,EncryptUtils.md5(xupwd));
            request.setAttribute("exist","恭喜您，修改登录密码成功！");
            return "user/upwdUpdate";
        }
        if(!upd.equals(user.getUpwd())){
            request.setAttribute("check","您的原登录密码错误，修改失败！");
            return "user/upwdUpdate";
        }

        return "user/upwdUpdate";
    }

    @RequestMapping("userdataFind")
    public String userdataFind(HttpServletRequest request,HttpSession session){
        Long uid=(Long)session.getAttribute(Constants.USER_ID_SESSION);
        User user= (User) userService.getById(uid);
        request.setAttribute("user",user);
        return  "user/userdataUpdate";
    }

    @PostMapping("userdataUpdate")
    public String userdataUpdate(HttpSession session,User user,HttpServletRequest request){
        String uname=(String)session.getAttribute(Constants.USER_IN_SESSION);
        user.setUname(uname);
        userService.update(user);
        request.setAttribute("exist","恭喜您，修改资料成功！");
        return  "user/userdataUpdate";
    }

}
