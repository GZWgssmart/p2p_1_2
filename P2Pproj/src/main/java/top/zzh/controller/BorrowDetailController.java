package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.BorrowDetail;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.BorrowApplyService;
import top.zzh.service.BorrowDetailService;
import top.zzh.vo.ControllerStatusVO;

/**
 * Created by 曾志湖 on 2017/12/24.
 */
@Controller
@RequestMapping("/borrowdetail")
public class BorrowDetailController {

    private Logger logger = LoggerFactory.getLogger(BorrowDetailController.class);
    @Autowired
    private BorrowDetailService borrowDetailService;
    @Autowired
    private BorrowApplyService borrowApplyService;

    @RequestMapping("save")
    @ResponseBody
    public ControllerStatusVO save(BorrowDetail borrowDetail){
        logger.info("添加借款详情信息");
        ControllerStatusVO statusVO = null;
        try {
            borrowDetailService.save(borrowDetail);
        }catch (RuntimeException e){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("update")
    @ResponseBody
    public ControllerStatusVO update(BorrowDetail borrowDetail){
        logger.info("修改借款详情信息");
        ControllerStatusVO statusVO = null;
        try {
            borrowDetailService.update(borrowDetail);
        }catch (RuntimeException e){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_UPDATE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_UPDATE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int page, int rows, BorrowDetail borrowDetail) {
        logger.info("借款详情信息分页+条件查询");
        return borrowDetailService.listPagerCriteria(page, rows, borrowDetail);
    }
}
