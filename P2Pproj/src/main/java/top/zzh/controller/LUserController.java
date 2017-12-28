package top.zzh.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.zzh.bean.*;
import top.zzh.common.CheckCodeUtils;
import top.zzh.common.Constants;
import top.zzh.common.EncryptUtils;
import top.zzh.common.Pager;
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
import java.util.List;

/**
 * Created by 赖勇建 on 2017/12/21 0021.
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
    public String showLogin(){
        return "/user/login";
    }

    @PostMapping("login")
    @ResponseBody
    public ControllerStatusVO login(HttpSession session, String name, HttpServletRequest request, String password, String code){
        logger.info("登录用户");
        Object obj = session.getAttribute(Constants.CODE_IN_SESSION);
        ControllerStatusVO statusVO = null;
        if (obj != null) {
            String checkCode = (String) obj;
            if (checkCode.equalsIgnoreCase(code)) {

                Object userObj=session.getAttribute(Constants.USER_IN_SESSION);
                if(userObj==null){
                    Subject subject = SecurityUtils.getSubject();
                    try {
                        subject.login(new UsernamePasswordToken(name, password));
                        Session sessionShiro = subject.getSession();//获取用户会话信息
                        sessionShiro.setAttribute(Constants.USER_IN_SESSION, name);
                        long userid=loginLogService.getByName(name);
                        LoginLog log=new LoginLog();
                        log.setUserId(userid);
                        log.setLoginIp(request.getRemoteHost());
                        loginLogService.save(log);

                        statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_SUCCESS);
                    } catch (AuthenticationException e) {
                        statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_FAIL);
                    }

                } else {
                    statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_ALREADY_LOGIN);
                }
            }else{
                statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_ERROR_CODE);
            }
        }

        return statusVO;
    }


    @GetMapping("userindex")
    public String userLogin(){

        return "/user/userindex";
    }


    @PostMapping("gainCode")
    @ResponseBody
    public Integer gainCode(String phone, HttpServletRequest request){
        logger.info("获取手机验证码");
        String result = GetPhoneMessage.getResult(phone);
        return Integer.parseInt(result);
    }

    @RequestMapping("forgetPassword")
    @ResponseBody
    public ControllerStatusVO forgetPassword(HttpServletRequest request,String phone,HttpSession session){
        logger.info("忘记密码");
        System.out.println(phone);
        ControllerStatusVO statusVO=null;
        User user=userService.getByPhone(phone);

        if(user==null){
            statusVO  = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_ERROR_EXIST);
            return statusVO;
        }

        List<String> stringList= roleService.listRoles(user.getUname());
        if(stringList==null){
            statusVO  = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_ERROR_EXIST_POWER);
            return statusVO;
        }

        if(user!=null && user.getState()==1 && stringList.size()!=0){
            LoginLog log=new LoginLog();
            log.setUserId(user.getUid());
            log.setLoginIp(request.getRemoteHost());
            loginLogService.save(log);
            session.setAttribute(Constants.USER_IN_SESSION, user.getUname());
            statusVO  = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_SUCCESS);
        }else{
            statusVO  = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_ERROR_EXIST_POWER);
        }

        return statusVO;
    }

    @GetMapping("forgetPasswordView")
    public String forgetPasswordView(){

        return "/user/forgetPassword";
    }

    @GetMapping("register")
    public String register(){

        return "/user/register";
    }


    @RequestMapping("checkPhone")
    @ResponseBody
    public ControllerStatusVO checkPhone(String phone){
        logger.info("验证手机号是否正确");
        ControllerStatusVO statusVO=null;
        User user=userService.getByPhone(phone);
        if(user!=null){
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_ERROR_ALREADYEXIST);
        }
        return  statusVO;
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
    public String registerSuccess(){

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
        logger.info("安全退出+退出日志");
        session.invalidate();
        return "user/login";
    }

    public LoginLogQuery getLoginLogQuery() {
        return loginLogQuery;
    }

    public void setLoginLogQuery(LoginLogQuery loginLogQuery) {
        this.loginLogQuery = loginLogQuery;
    }
}
