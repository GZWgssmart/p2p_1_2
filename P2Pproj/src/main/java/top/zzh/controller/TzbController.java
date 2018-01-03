package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.Tzb;
import top.zzh.common.Constants;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.TzbService;
import top.zzh.vo.ControllerStatusVO;
import top.zzh.vo.TzbVO;

import javax.servlet.http.HttpSession;

/**
 * Created by 曾志湖 on 2017/12/26.
 * 投资表
 */
@Controller
@RequestMapping("/tz")
public class TzbController {

    private Logger logger = LoggerFactory.getLogger(TzbController.class);
    @Autowired
    private TzbService tzbService;

    @RequestMapping("save")
    @ResponseBody
    public ControllerStatusVO save(Tzb tzb){
        logger.info("开始投资");
        ControllerStatusVO statusVO = null;
        try {
            tzbService.save(tzb);
        }catch (RuntimeException e){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int pageIndex,int pageSize, TzbVO tzbVO) {
        logger.info("投资信息+条件查询");
        return tzbService.listPagerCriteria(pageIndex, pageSize, tzbVO);
    }

    @RequestMapping("pageById")
    @ResponseBody
    public Pager pageById(int pageIndex, int pageSize, HttpSession session) {
        logger.info("前台查看投资进度");
        Long id=(Long)session.getAttribute(Constants.USER_ID_SESSION);
        return tzbService.listPagerById(pageIndex,pageSize,id);
    }


    @RequestMapping("page")
    public String page(){
        return "manager/tz";
    }
}
