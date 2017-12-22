package top.zzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Huser")
public class HUserController {


    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
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
