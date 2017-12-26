package top.zzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.Dynamic;
import top.zzh.common.Pager;
import top.zzh.service.DynamicService;

@Controller
@RequestMapping("/dynamic")
public class DynamicController {
    @Autowired
    private DynamicService dynamicService;

    @RequestMapping("save")
    @ResponseBody
    public String save(Dynamic dynamic){
        dynamicService.save(dynamic);
        return  "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(Dynamic dynamic){
        dynamicService.update(dynamic);
        return "";
    }

    @RequestMapping("page")
    public String page(){
        return "";
    }

    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int page,int rows,Dynamic dynamic){
        return dynamicService.listPagerCriteria(page,rows,dynamic);
    }
}
