package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.BorrowApply;
import top.zzh.common.Pager;
import top.zzh.service.HkbService;
import top.zzh.vo.HkbVO;

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

    @RequestMapping("hk_page")
    public String hkbPage(){
        return "manager/hkb";
    }
}
