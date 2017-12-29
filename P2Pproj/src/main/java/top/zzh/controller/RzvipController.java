package top.zzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zzh.bean.RzVip;
import top.zzh.bean.User;
import top.zzh.common.Constants;
import top.zzh.service.RzVipService;
import top.zzh.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/12/28 0028.
 */
@Controller
@RequestMapping("/rzvip")
public class RzvipController {

    @Autowired
    private UserService userService;

    @Autowired
    private RzVipService rzVipService;

    @GetMapping("rzvipaddView")
    public String rzvipaddView(HttpSession session,HttpServletRequest request){
        String name=(String)session.getAttribute(Constants.USER_IN_SESSION);

        User user=userService.getByface(name);
        RzVip rzVip= (RzVip) rzVipService.getById(user.getUid());
        if(rzVip==null){
            return "/user/rzvipAdd";
        }
        if(rzVip.getUid()!=null){
            request.setAttribute("rzVip",rzVip);
            return "/user/rzvipUpdate";
        }
        return  "";
    }


    @PostMapping("rzvipSave")
    public String rzvipSave(HttpSession session, RzVip rzVip, HttpServletRequest request){

        String name=(String)session.getAttribute(Constants.USER_IN_SESSION);

        User user=userService.getByface(name);
        rzVip.setUid(user.getUid());
        rzVipService.save(rzVip);
        request.setAttribute("rzVip",rzVip);

        return  "/user/rzvipUpdate";
    }

    @PostMapping("update")
    public String update(HttpSession session, RzVip rzVip, HttpServletRequest request){
        Long uid=(Long)session.getAttribute(Constants.USER_ID_SESSION);
        rzVip.setUid(uid);
        rzVipService.update(rzVip);
        request.setAttribute("rzVip",rzVip);
        request.setAttribute("exist","恭喜你，修改成功！");
        return "/user/rzvipUpdate";
    }

}
