package top.zzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zzh.bean.User;
import top.zzh.common.Constants;
import top.zzh.service.LoginLogService;
import top.zzh.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    private UserService userService;

   @RequestMapping("welcome")
    public String welcome(){
        return "manager/welcome";
    }
    @RequestMapping("managerindex")
    public String managerindex(){
        return "common/managerindex";
    }

    @RequestMapping("users")
    public String users(){
        return "manager/borrowapply";
    }

    @RequestMapping("user")
    public String user(HttpSession session, HttpServletRequest request){
        if(session.getAttribute(Constants.USER_IN_SESSION)==null || session.getAttribute(Constants.USER_IN_SESSION)==""){

            return "user/nopower";
        }else{
            String name= (String) session.getAttribute(Constants.USER_IN_SESSION);
            String time=loginLogService.getByloginTime(name);
            User user=userService.getByface(name);
            request.setAttribute("time",time);
            request.setAttribute("face",user.getFace());
            return "user/userindex";
        }
    }
    @RequestMapping("chongzhi")
    public String chongzhi(){
        return "user/chongzhi";
    }
    @RequestMapping("disanfang")
    public String disanfang(){
        return "user/disanfang";
    }
    @RequestMapping("history")
    public String history(){
        return "user/history";
    }
    @RequestMapping("hongbao")
    public String hongbao(){
        return "user/hongbao";
    }
    @RequestMapping("huikuan")
    public String huikuan(){
        return "user/huikuan";
    }
    @RequestMapping("login")
    public String login(){
        return "user/login";
    }
    //推荐链接注册
    @RequestMapping("register?userCode={userCode}")
    public String recommendReg(){
        return "user/register";
    }
    @RequestMapping("register")
    public String register(){
        return "user/register";
    }
    @RequestMapping("registerSuccess")
    public String registerSuccess(){
        return "user/registerSuccess";
    }
    @RequestMapping("tixian")
    public String tixian(){
        return "user/tixian";
    }
    @RequestMapping("touzi")
    public String touzi(){
        return "user/touzi";
    }
    @RequestMapping("xitong")
    public String xitong(){
        return "user/xitong";
    }
    @RequestMapping("zhanghu")
    public String zhanghu(){
        return "user/zhanghu";
    }
    @RequestMapping("zijin")
    public String zijin(){
        return "user/zijin";
    }
    @RequestMapping("about")
    public String about(){
        return "index/about";
    }
    @RequestMapping("ad")
    public String ad(){
        return "index/ad";
    }
    @RequestMapping("ad1")
    public String ad1(){
        return "index/ad1";
    }
    @RequestMapping("contract")
    public String contract(){
        return "index/contract";
    }
    @RequestMapping("fl1")
    public String f1(){
        return "index/fl1";
    }
    @RequestMapping("fl2")
    public String f2(){
        return "index/fl2";
    }
    @RequestMapping("help")
    public String help(){
        return "index/help";
    }
    @RequestMapping("hezuo")
    public String hezuo(){
        return "index/hezuo";
    }
    @RequestMapping("info")
    public String info(){
        return "index/info";
    }
    @RequestMapping("list")
    public String list(){
        return "index/list";
    }
    @RequestMapping("managerTuandui")
    public String managerTuandui(){
        return "index/managerTuandui";
    }
    @RequestMapping("notice")
    public String notice(){
        return "index/notice";
    }
    @RequestMapping("report")
    public String report(){
        return "index/report";
    }
    @RequestMapping("tuandui")
    public String tuandui(){
        return "index/tuandui";
    }
    @RequestMapping("zhaopin")
    public String zhaopin(){
        return "index/zhaopin";
    }
    @RequestMapping("zifei")
    public String zifei(){
        return "index/zifei";
    }
}
