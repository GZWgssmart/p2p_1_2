package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.BorrowApply;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.BorrowApplyService;
import top.zzh.vo.ControllerStatusVO;

import java.util.Date;

/**
 * @author 曾志湖
 * @time 12.25
 * @version 1.0
 * 申请借款表
 */
@Controller
@RequestMapping("/borrowapply")
public class BorrowApplyController {

    private Logger logger = LoggerFactory.getLogger(BorrowApplyController.class);

    @Autowired
    private BorrowApplyService borrowApplyService;

    @RequestMapping("save")
    @ResponseBody
    public ControllerStatusVO save(BorrowApply borrowApply){
        logger.info("添加申请借款人基本信息");
        ControllerStatusVO statusVO = null;
        try {
            borrowApplyService.save(borrowApply);
        }catch (RuntimeException e){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("update")
    @ResponseBody
    public ControllerStatusVO update(BorrowApply borrowApply){
        logger.info("修改申请借款人基本信息");
        ControllerStatusVO statusVO = null;
        try {
            borrowApplyService.update(borrowApply);
        }catch (RuntimeException e){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_UPDATE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_UPDATE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("getById")
    @ResponseBody
    public ControllerStatusVO getById(@PathVariable("baid") Long baid){
        ControllerStatusVO statusVO = null;
        try {
            borrowApplyService.getById(baid);
        }catch (RuntimeException e){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_UPDATE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_UPDATE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("updateState/{id}/{state}")
    @ResponseBody
    public ControllerStatusVO updateState(@PathVariable("id") Long id,@PathVariable("state") int state ,BorrowApply borrowApply){
       logger.info("审核借款人");
       borrowApply.setBaid(id);
       borrowApply.setState((byte)state);
        ControllerStatusVO statusVO = null;
        try {
            borrowApplyService.updateState(borrowApply);
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CHECK_USER_SUCCESS);
        }catch (RuntimeException e){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CHECK_USER_FAIL);
        }
        return statusVO;
    }



    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int pageIndex, int pageSize, BorrowApply borrowApply) {
        logger.info("借款基本信息分页+条件查询");
        return borrowApplyService.listPagerCriteria(pageIndex, pageSize, borrowApply);
    }


}
