package top.zzh.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Huser")
public class HUserController {


    private Logger logger = LoggerFactory.getLogger(HUserController.class);

    @RequestMapping("logout")
    public String logout(HttpSession session){
        logger.info("安全退出");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        subject.getSession().removeAttribute("user");
        return "manager/login";
    }
    //后台用户中心页面
    @RequestMapping("page")
    public String page(){
        return "manager/index";
    }
       //后台用户登录页面
    @RequestMapping("login")
    public String login(){
        return "manager/login";
    }

    //后台用户注册页面
    @RequestMapping("register")
    public String register(){
        return "manager/register";
    }


}
