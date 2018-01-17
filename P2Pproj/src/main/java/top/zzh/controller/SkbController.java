package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.zzh.bean.BorrowApply;
import top.zzh.bean.Hkb;
import top.zzh.bean.Skb;
import top.zzh.common.Pager;
import top.zzh.service.SkbService;
import top.zzh.vo.HkbVO;
import top.zzh.vo.SkbVO;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 曾志湖 on 2018/1/3.
 * 收款表
 */
@Controller
@RequestMapping("/sk")
public class SkbController {

    private Logger logger = LoggerFactory.getLogger(SkbController.class);
    @Autowired
    private SkbService skbService;

    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int pageIndex, int pageSize, SkbVO skbVO) {
        logger.info("收款基本信息分页+条件查询");
        return skbService.listPagerCriteria(pageIndex, pageSize, skbVO);
    }


    @RequestMapping("skDetail/{juid}")
    public ModelAndView soukuan(HttpSession session, Integer pageNo, SkbVO skb, @PathVariable("juid") Long juid) {
        logger.info("后台管理员查看收款详情");
        skb.setJuid(juid);
        if(pageNo==0){
            pageNo = 1;
        }
        Pager obj = skbService.find(pageNo,15,skb);
        List<SkbVO> skbVOList = new ArrayList<>();
        for(Object o:obj.getRows()){
            SkbVO skbVO = (SkbVO) o;
            skbVOList.add(skbVO);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manager/skdetail");
        modelAndView.addObject("obj",skbVOList);
        modelAndView.addObject("page",obj);
        return modelAndView;
    }
}
