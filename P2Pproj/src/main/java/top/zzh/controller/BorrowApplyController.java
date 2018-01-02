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
import top.zzh.service.*;
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
    @Autowired
    private SwayService swayService;


    @RequestMapping("borrow_page")
    public String borrowpage(HttpSession session, HttpServletRequest request){
        logger.info("获取标种表和借款类型表的数据");
        List<Bz> bzList = (List)bzService.listAll();
        List<Jklx> jklxList = (List)jklxService.listAll();
        List<Sway> swayList = (List)swayService.listAll();
        request.setAttribute("bzList",bzList);
        request.setAttribute("jklxList",jklxList);
        request.setAttribute("swayList",swayList);
        return "user/borrowapply";
    }

    @RequestMapping("save")
    @ResponseBody
    public ControllerStatusVO save(@RequestParam("file") MultipartFile[] picture,
                                   HttpSession session, HttpServletRequest request, ShBorrow shBorrow,BorrowApply borrowApply, BorrowDetail borrowDetail){
        logger.info("新增借款信息");
        ControllerStatusVO statusVO = null;
        String name = (String) session.getAttribute(Constants.USER_IN_SESSION);
        Long userid = (Long)session.getAttribute(Constants.USER_ID_SESSION);
        borrowApply.setRname(name);
        borrowApply.setUid(userid);
        //默认状态为未审核,其他默认写死
        borrowApply.setState((byte)1);
        borrowApply.setHuid(1L);
        borrowApply.setReason("审核不通过");
        borrowApply.setTime(new Date());
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
        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String date1 = format.format(time);
        String fpic = "";
        String ypic = "";
        String qpic = "";
        String tpic = "";
        for (int i=0;i<picture.length;i++){
            String name1 = date1+picture[i].getOriginalFilename();
            if (i==0){
                fpic = name1;
            }else if(i==1){
                ypic = name1;
            }else if(i==2){
                qpic = name1;
            }else if (i==3){
                tpic = name1;
            }
            try {
                picture[i].transferTo(new File(PathUtils.uploadDir(request)+"/"+name1));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        borrowDetail.setBdid(borrowDetail.getBdid());
        borrowDetail.setFpic(fpic);
        borrowDetail.setYpic(ypic);
        borrowDetail.setTpic(tpic);
        borrowDetail.setQpic(qpic);
        borrowDetailService.updateTupian(borrowDetail);
        request.setAttribute("borrowApply",borrowApply);
        request.setAttribute("borrowDetail",borrowDetail);
        request.setAttribute("exist","申请借款成功！");
        ControllerStatusEnum.BORROW_SAVE_WAIT.setCode(Integer.parseInt(borrowDetail.getBdid().toString()));
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.BORROW_SAVE_WAIT);
        return statusVO;
    }


    @RequestMapping("update")
    @ResponseBody
    public String update(HttpServletRequest request,HttpSession session,BorrowApply borrowApply,BorrowDetail borrowDetail){
        logger.info("修改申请借款资料");
        ControllerStatusVO statusVO = null;
        Calendar cal = Calendar.getInstance();
        Date date = new Timestamp(cal.getTime().getTime());
        cal.setTime(date);
        //借款期限默认以月为单位
        cal.add(Calendar.MONTH, borrowApply.getTerm());
        //截止时间
        borrowApply.setDeadline(new Timestamp(cal.getTime().getTime()));
        borrowApply.setReason("审核不通过");
        borrowApply.setState((byte)1);
        borrowApplyService.update(borrowApply);
        borrowDetailService.update(borrowDetail);
        request.setAttribute("borrowApply",borrowApply);
        request.setAttribute("borrowDetail",borrowDetail);
        request.setAttribute("msg","修改申请借款资料成功");
        return "user/borrowapply";
    }

    @RequestMapping("updateState/{id}/{state}")
    @ResponseBody
    public ControllerStatusVO updateState(@PathVariable("id") Long id,@PathVariable("state") int state ,BorrowApply borrowApply,HttpSession session){
       logger.info("后台管理员审核借款人");
       ControllerStatusVO statusVO = null;
       HUser HUser = (HUser)session.getAttribute("HUser");
       borrowApply.setHuid(HUser.getHuid());
       borrowApply.setReason(borrowApply.getReason());
       borrowApply.setBaid(id);
       borrowApply.setState((byte)state);
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

    @RequestMapping("pager")
    @ResponseBody
    public Pager pager(int pageIndex, int pageSize) {
        logger.info("显示审核列表");
        return borrowApplyService.listPager(pageIndex,pageSize);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
