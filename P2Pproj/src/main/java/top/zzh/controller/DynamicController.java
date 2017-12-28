package top.zzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.Dynamic;
import top.zzh.common.Pager;
import top.zzh.service.DynamicService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/dynamic")
public class DynamicController {
    @Autowired
    private DynamicService dynamicService;

    @RequestMapping("initAdd")
    public String initAdd(){
        return "dynamic/dynamicAdd";
    }

    @RequestMapping("save")
    @ResponseBody
    public String save(Dynamic dynamic){
        dynamicService.save(dynamic);
        return  "dynamic/dynamic";
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

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
