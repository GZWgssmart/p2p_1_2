package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zzh.bean.*;
import top.zzh.common.Constants;
import top.zzh.common.Pager;
import top.zzh.common.PathUtil;
import top.zzh.common.PathUtils;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.BorrowApplyService;
import top.zzh.service.BorrowDetailService;
import top.zzh.service.BzService;
import top.zzh.service.JklxService;
import top.zzh.vo.ControllerStatusVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private BorrowDetailService borrowDetailService;
    @Autowired
    private BzService bzService;
    @Autowired
    private JklxService jklxService;

    @RequestMapping("borrow_page")
    public String borrowpage(HttpSession session, HttpServletRequest request){
        logger.info("获取标种表和借款类型表的数据");
        List<Bz> bzList = (List)bzService.listAll();
        List<Jklx> jklxList = (List)jklxService.listAll();
        request.setAttribute("bzList",bzList);
        request.setAttribute("jklxList",jklxList);
        return "";
    }

    @RequestMapping("save")
    @ResponseBody
    public ControllerStatusVO save(HttpSession session, HttpServletRequest request, BorrowApply borrowApply, BorrowDetail borrowDetail){
        logger.info("新增借款信息");
        ControllerStatusVO statusVO = null;
        User user = (User)session.getAttribute(Constants.USER_IN_SESSION);
        borrowApply.setRname(user.getRname());
        borrowApply.setUid(user.getUid());
        //默认状态为未审核
        borrowApply.setState((byte)1);
        Calendar cal = Calendar.getInstance();
        Date date = new Timestamp(cal.getTime().getTime());
        cal.setTime(date);
        //借款期限默认以月为单位
        cal.add(Calendar.MONTH, borrowApply.getTerm());
        borrowApply.setDeadline(new Timestamp(cal.getTime().getTime()));
        borrowApplyService.save(borrowApply);
        borrowDetail.setCpname("YRB"+borrowApply.getBzid()+borrowApply.getLxid()+borrowApply.getBaid());
        borrowDetail.setBaid(borrowApply.getBaid());
        borrowDetail.setMoney(borrowApply.getMoney());
        borrowDetailService.save(borrowDetail);
        ControllerStatusEnum.BORROW_SAVE_WAIT.setCode(Integer.parseInt(borrowDetail.getBdid().toString()));
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.BORROW_SAVE_WAIT);
        return statusVO;
    }

    @RequestMapping("save_image")
    @ResponseBody
    public String addImage(@RequestParam("file") MultipartFile[] picture,@RequestParam("baid") Long bdid,HttpServletRequest request){
        logger.info("修改借款详情图片");
        BorrowDetail borrowDetail = new BorrowDetail();
        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = format.format(time);
        String fpic = "";
        String ypic = "";
        String qpic = "";
        String tpic = "";
        for (int i=0;i<picture.length;i++){
            String name = date+picture[i].getOriginalFilename();
            if (i==0){
                fpic = name;
            }else if(i==1){
                ypic = name;
            }else if(i==2){
                qpic = name;
            }else if (i==3){
                tpic = name;
            }
            try {
                picture[i].transferTo(new File(PathUtil.uploadDir(request)+"/"+name));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        borrowDetail.setBdid(bdid);
        borrowDetail.setFpic(fpic);
        borrowDetail.setYpic(ypic);
        borrowDetail.setTpic(tpic);
        borrowDetail.setQpic(qpic);
        borrowDetailService.updateTupian(borrowDetail);
        return "";
    }

    @RequestMapping("updateState/{id}/{state}")
    @ResponseBody
    public ControllerStatusVO updateState(@PathVariable("id") Long id,@PathVariable("state") int state ,BorrowApply borrowApply){
       logger.info("后台管理员审核借款人");
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


    @RequestMapping("list")
    public String list(HttpServletRequest request){
        logger.info("前台用户查看个人借款信息");
        List<BorrowApply> borrowApplyList = (List)borrowApplyService.listAll();
        request.setAttribute("borrowApplyList",borrowApplyList);
        return "";
    }

    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int pageIndex, int pageSize, BorrowApply borrowApply) {
        logger.info("借款基本信息分页+条件查询");
        return borrowApplyService.listPagerCriteria(pageIndex, pageSize, borrowApply);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
