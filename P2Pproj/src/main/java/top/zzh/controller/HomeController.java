package top.zzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.Home;
import top.zzh.common.Pager;
import top.zzh.query.HomeQuery;
import top.zzh.service.HomeService;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @RequestMapping("save")
    @ResponseBody
    public Home save() {
        Home home = new Home();
        homeService.save(home);
        return home;
    }

    @RequestMapping("update")
    @ResponseBody
    public Home update(){
        Home home = new Home();
        homeService.update(home);
        return home;
    }

    @RequestMapping("page")
    public String page() {
        return "home/home";
    }

    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int page, int rows, HomeQuery homeQuery) {
        return homeService.listPagerCriteria(page, rows, homeQuery);
    }

}
