package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.BorrowApply;
import top.zzh.bean.Tzb;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.TzbService;
import top.zzh.vo.ControllerStatusVO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 曾志湖 on 2017/12/26.
 * 投资表
 */
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
    public Pager pagerCriteria(int pageIndex,int pageSize, Tzb tzb) {
        logger.info("投资信息+条件查询");
        return tzbService.listPagerCriteria(pageIndex, pageSize, tzb);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
