package top.zzh.controller;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.BorrowDetail;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.BorrowDetailService;
import top.zzh.vo.BorrowApplyVO;
import top.zzh.vo.BorrowDetailVO;
import top.zzh.vo.ControllerStatusVO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 曾志湖 on 2017/12/24.
 * 借款详情
 */
@Controller
@RequestMapping("/borrowdetail")
public class BorrowDetailController {

    private Logger logger = LoggerFactory.getLogger(BorrowDetailController.class);
    @Autowired
    private BorrowDetailService borrowDetailService;

    private BorrowDetailVO borrowDetail;

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
    public Pager pagerCriteria(int pageIndex, int pageSize) {
        logger.info("借款详情信息分页+条件查询");
        return borrowDetailService.listPagerCriteria(pageIndex, pageSize, borrowDetail);
    }


    public void setBorrowDetail(BorrowDetailVO borrowDetail) {
        this.borrowDetail = borrowDetail;
    }
    public BorrowDetailVO getBorrowDetail() {
        return borrowDetail;
    }
}
