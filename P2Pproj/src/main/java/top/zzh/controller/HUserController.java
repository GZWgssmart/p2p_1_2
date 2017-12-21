package top.zzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Huser")
public class HUserController {



    //后台用户中心页面
    @RequestMapping("page")
    public String page(){
        return "manager/index";
    }
    //后台用户中心页面
    @RequestMapping("login")
    public String login(){
        return "manager/login";
    }


}
