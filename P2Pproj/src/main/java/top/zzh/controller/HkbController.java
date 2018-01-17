package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.zzh.bean.Hkb;
import top.zzh.bean.Tzb;
import top.zzh.common.Constants;
import top.zzh.common.Pager;
import top.zzh.service.HkbService;
import top.zzh.vo.HkbVO;
import top.zzh.vo.TzbVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 曾志湖 on 2018/1/3.
 * 还款表
 */
@Controller
@RequestMapping("/hk")
public class HkbController {

    private Logger logger = LoggerFactory.getLogger(HkbController.class);

    @Autowired
    private HkbService hkbService;

    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int pageIndex, int pageSize, HkbVO hkbVO) {
        logger.info("后台查看用户还款基本信息分页+条件查询");
        return hkbService.listPagerCriteria(pageIndex, pageSize, hkbVO);
    }


    @RequestMapping("hkDetail/{uid}")
    public ModelAndView touzi(HttpSession session, Integer pageNo, Hkb hkb,@PathVariable("uid") Long uid) {
        logger.info("后台管理员查看用户还款详情");
        hkb.setUid(uid);
        if(pageNo==0){
            pageNo = 1;
        }
        Pager obj = hkbService.find(pageNo,5,hkb);
        List<HkbVO> hkbVOList = new ArrayList<>();
        for(Object o:obj.getRows()){
            HkbVO hkbVO = (HkbVO) o;
            hkbVOList.add(hkbVO);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manager/hkdetail");
        modelAndView.addObject("obj",hkbVOList);
        modelAndView.addObject("page",obj);
        return modelAndView;
    }
}
