package top.zzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.Media;
import top.zzh.common.Pager;
import top.zzh.service.MediaService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/media")
public class MediaController {
    @Autowired
    private MediaService mediaService;

    /**
     * 跳转页面
     * @return
     * */
    @RequestMapping("initAdd")
    public String initAdd(){
        return "media/mediaAdd";
    }

    @RequestMapping("save")
    @ResponseBody
    public String save(Media media){
       mediaService.save(media);
       return "media/mediaAdd";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(Media media){
          mediaService.update(media);
        return "";
    }

    @RequestMapping("page")
    public String page(){
        return "media/mediaList";
    }

    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int page,int rows,Media media){
        return mediaService.listPagerCriteria(page,rows,media);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
