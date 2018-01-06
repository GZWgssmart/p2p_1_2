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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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



    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int pageIndex, int pageSize, BorrowApplyVO borrowDetail) {
        logger.info("借款详情信息分页+条件查询");
        return borrowDetailService.listPagerCriteria(pageIndex, pageSize, borrowDetail);
    }

    @RequestMapping("detailView")
    public String detailView(HttpServletRequest request, String row){
        String baid = null;
        if(row.contains(",")){
            String rowString[] = row.split(",");
            for(int i=0;i<rowString.length;i++){
                baid = rowString[i];
            }
            BorrowDetailVO borrowDetailVO = borrowDetailService.findDetails(Long.valueOf(baid));
            request.setAttribute("borrowDetailVO",borrowDetailVO);
            return "manager/borrowdetail";
        }
        BorrowDetailVO borrowDetailVO = borrowDetailService.findDetails(Long.valueOf(row));
        request.setAttribute("borrowDetailVO",borrowDetailVO);
        return "manager/borrowdetail";
    }

}
