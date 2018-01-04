package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.BorrowApply;
import top.zzh.common.Pager;
import top.zzh.service.SkbService;
import top.zzh.vo.SkbVO;

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

    @RequestMapping("manager_page")
    public String page(){
        logger.info("后台用户收款页面");
        return "manager/sk";
    }

}
