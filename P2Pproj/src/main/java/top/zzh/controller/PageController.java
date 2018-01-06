package top.zzh.controller;

import javafx.scene.layout.BackgroundImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.zzh.bean.LogMoney;
import top.zzh.bean.User;
import top.zzh.common.Constants;
import top.zzh.service.LogMoneyService;
import top.zzh.service.LoginLogService;
import top.zzh.service.UserMoneyService;
import top.zzh.service.UserService;
import top.zzh.vo.ControllerStatusVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMoneyService userMoneyService;

    @Autowired
    private LogMoneyService logMoneyService;

    //前台投资理财计算器
    @RequestMapping("cal")
    public String cal() {
        return "common/calculator";
    }

    @RequestMapping("welcome")
    public String welcome() {
        return "manager/welcome";
    }

    //管理员主界面
    @RequestMapping("managerindex")
    public String managerindex() {
        return "common/managerindex";
    }

    @RequestMapping("users")
    public String users() {
        return "manager/borrowapply";
    }

    @RequestMapping("user")
    public String user(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute(Constants.USER_IN_SESSION) == null || session.getAttribute(Constants.USER_IN_SESSION) == "") {

            return "user/nopower";
        } else {
            String name = (String) session.getAttribute(Constants.USER_IN_SESSION);
            String time = loginLogService.getByloginTime(name);
            User user = userService.getByface(name);
            request.setAttribute("time", time);
            request.setAttribute("face", user.getFace());
            return "user/userindex";
        }
    }

    @RequestMapping("chongzhi")
    public String chongzhi() {
        return "user/chongzhi";
    }

    @RequestMapping("disanfang")
    public String disanfang(HttpSession session) {
        Long id =(Long)session.getAttribute(Constants.USER_ID_SESSION);
        User user=(User)userService.getById(id);
        session.setAttribute("users",user);
        return "user/disanfang";
    }

    @RequestMapping("history")
    public String history() {
        return "user/history";
    }

    @RequestMapping("hongbao")
    public String hongbao() {
        return "user/hongbao";
    }

    @RequestMapping("huikuan")
    public String huikuan() {
        return "user/huikuan";
    }

    @RequestMapping("login")
    public String login() {
        return "user/login";
    }

    //推荐链接注册
    @RequestMapping("register?userCode={userCode}")
    public String recommendReg() {
        return "user/register";
    }

    @RequestMapping("register")
    public String register() {
        return "user/register";
    }

    @RequestMapping("registerSuccess")
    public String registerSuccess() {
        return "user/registerSuccess";
    }
    @RequestMapping("tixian")
    public String tixian(HttpSession session) {
        Long id = (Long) session.getAttribute(Constants.USER_ID_SESSION);
        //用户当前可用余额
        Long bigDecimal = userMoneyService.getMoney(id.toString());
        Double kymoney = Double.valueOf(bigDecimal);
        System.out.println(bigDecimal);
        session.setAttribute("kymoney",kymoney);
        return "user/tixian";
    }

   /* @RequestMapping("tixian")
    public ModelAndView tixian(HttpSession session,String actualMoney) {
        System.out.println(actualMoney);
        Long id = (Long) session.getAttribute(Constants.USER_ID_SESSION);
        //用户当前可用余额
        Long bigDecimal = userMoneyService.getMoney(id.toString());
        Double kymoney = Double.valueOf(bigDecimal);
        ModelAndView m = new ModelAndView();
        if (actualMoney!=null){
            //提现后可用余额
            try {

                kymoney = kymoney - Double.valueOf(actualMoney);
                userMoneyService.updateMoney(kymoney.toString(), id.toString());
                LogMoney logMoney = new LogMoney();
                logMoney.setUid(id);
                logMoney.setType((byte) 1);
                logMoney.setOut(BigDecimal.valueOf(Double.valueOf(actualMoney)));
                logMoneyService.save(logMoney);
                m.addObject("message", "请等待审核！");
            }catch (Exception e){
                m.addObject("message", "提现失败！");
            }
        }
        m.setViewName("user/tixian");
        m.addObject("kymoney",kymoney);
        return m;
    }*/

    @RequestMapping("touzi")
    public String touzi() {
        return "user/touzi";
    }

    @RequestMapping("xitong")
    public String xitong() {
        return "user/xitong";
    }

    @RequestMapping("zhanghu")
    public String zhanghu() {
        return "user/zhanghu";
    }

    @RequestMapping("zijin")
    public String zijin() {
        return "user/zijin";
    }

    @RequestMapping("about")
    public String about() {
        return "index/about";
    }

    @RequestMapping("ad")
    public String ad() {
        return "index/ad";
    }

    @RequestMapping("ad1")
    public String ad1() {
        return "index/ad1";
    }

    @RequestMapping("contract")
    public String contract() {
        return "index/contract";
    }

    @RequestMapping("fl1")
    public String f1() {
        return "index/fl1";
    }

    @RequestMapping("fl2")
    public String f2() {
        return "index/fl2";
    }

    @RequestMapping("help")
    public String help() {
        return "index/help";
    }

    @RequestMapping("hezuo")
    public String hezuo() {
        return "index/hezuo";
    }

    @RequestMapping("info")
    public String info() {
        return "index/info";
    }

    @RequestMapping("list")
    public String list() {
        return "index/list";
    }

    @RequestMapping("managerTuandui")
    public String managerTuandui() {
        return "index/managerTuandui";
    }

    @RequestMapping("notice")
    public String notice() {
        return "index/notice";
    }

    @RequestMapping("report")
    public String report() {
        return "index/report";
    }

    @RequestMapping("tuandui")
    public String tuandui() {
        return "index/tuandui";
    }

    @RequestMapping("zhaopin")
    public String zhaopin() {
        return "index/zhaopin";
    }

    @RequestMapping("zifei")
    public String zifei() {
        return "index/zifei";
    }
}
