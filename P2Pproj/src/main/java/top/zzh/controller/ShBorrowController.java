package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.ShBorrow;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.ShBorrowService;
import top.zzh.vo.ControllerStatusVO;
import top.zzh.vo.ShBorrowVO;

/**
 * Created by 曾志湖 on 2017/12/26.
 * 借款审核
 */
@Controller
@RequestMapping("/shborrow")
public class ShBorrowController {

    private Logger logger = LoggerFactory.getLogger(ShBorrowController.class);
    @Autowired
    private ShBorrowService shBorrowService;

    @RequestMapping("page")
    public String page(){
        return "shenhe/shborrowShenhe";
    }

    @RequestMapping("save")
    @ResponseBody
    public ControllerStatusVO save(ShBorrow shBorrow){
        logger.info("审核借款信息");
        ControllerStatusVO statusVO = null;
        try{
            shBorrowService.save(shBorrow);
        }catch (RuntimeException e){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CHECK_USER_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CHECK_USER_SUCCESS);
        return statusVO;
    }

    @RequestMapping("update")
    @ResponseBody
    public ControllerStatusVO update(ShBorrow shBorrow){
        logger.info("修改审核信息");
        ControllerStatusVO statusVO = null;
        try {
            shBorrowService.update(shBorrow);
        }catch (RuntimeException e){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_UPDATE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_UPDATE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int pageIndex,int pageSize, ShBorrowVO shBorrowVO) {
        logger.info("借款审核+条件查询");
        return shBorrowService.listPagerCriteria(pageIndex, pageSize, shBorrowVO);
    }


}
