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

    @RequestMapping("remove")
    @ResponseBody
    public ControllerStatusVO remove(@PathVariable("baid") Long baid){
        logger.info("删除申请借款人基本信息");
        ControllerStatusVO statusVO = null;
        try {
            borrowApplyService.removeById(baid);
        }catch (RuntimeException e){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_DELETE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_DELETE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int page, int rows, BorrowApply borrowApply) {
        logger.info("借款基本信息分页+条件查询");
        return borrowApplyService.listPagerCriteria(page, rows, borrowApply);
    }

}
