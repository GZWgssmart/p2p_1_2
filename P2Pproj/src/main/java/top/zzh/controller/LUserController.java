package top.zzh.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.LoginLog;
import top.zzh.bean.User;
import top.zzh.bean.UserRole;
import top.zzh.common.Constants;
import top.zzh.common.EncryptUtils;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.message.GetPhoneMessage;
import top.zzh.service.LoginLogService;
import top.zzh.service.RoleService;
import top.zzh.service.UserService;
import top.zzh.vo.ControllerStatusVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
@Controller
@RequestMapping("/luser")
public class LUserController {

    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("login_page")
    public String showLogin(){
        return "/user/login";
    }

    @PostMapping("login")
    @ResponseBody
    public ControllerStatusVO login(HttpSession session, String name, HttpServletRequest request, String password, String code){
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
        System.out.println(phone);
        String result = GetPhoneMessage.getResult(phone);
        return Integer.parseInt(result);
    }

    @RequestMapping("forgetPassword")
    @ResponseBody
    public ControllerStatusVO forgetPassword(HttpServletRequest request,String phone,HttpSession session){
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
        ControllerStatusVO statusVO=null;
        User user=userService.getByPhone(phone);
        if(user!=null){
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_ERROR_ALREADYEXIST);
        }

        return  statusVO;
    }

    @PostMapping("registerSave")
    @ResponseBody
    public ControllerStatusVO  registerSave(HttpSession session,User user){
        ControllerStatusVO statusVO=null;
        String pwd=EncryptUtils.md5(user.getUpwd());
        user.setUpwd(pwd);
        userService.register(user);
        System.out.println("新增的id为："+user.getUid());
        UserRole userRole=new UserRole();
        userRole.setRoleId(3);
        userRole.setUserId(Math.toIntExact(user.getUid()));
        roleService.save(userRole);

        session.setAttribute("uname",user.getUname());
        statusVO=ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_SUCCESS);
        return statusVO;
    }


    @GetMapping("registerSuccess")
    public String registerSuccess(){

        return "/user/registerSuccess";
    }
}
