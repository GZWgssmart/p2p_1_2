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
import top.zzh.common.PathUtils;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.*;
import top.zzh.vo.BorrowDetailVO;
import top.zzh.vo.ControllerStatusVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private UserService userService;

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
    public String save(@RequestParam("file") MultipartFile[] picture,
                       HttpSession session, HttpServletRequest request, ShBorrow shBorrow,BorrowApply borrowApply, BorrowDetail borrowDetail) throws Exception{
        logger.info("新增借款信息");
        String name = (String) session.getAttribute(Constants.USER_IN_SESSION);
        Long userid = (Long)session.getAttribute(Constants.USER_ID_SESSION);
        borrowApply.setRname(name);
        borrowApply.setUid(userid);
        //默认状态为未审核,其他默认写死
        borrowApply.setState((byte)1);
        borrowApply.setHuid(1L);
        borrowApply.setReason("未审核");
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
        //已投金额默认新增为0
        borrowDetail.setMoney(BigDecimal.valueOf(0));
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
            picture[i].transferTo(new File(PathUtils.uploadDir(request)+"/"+name1));
        }
        borrowDetail.setBdid(borrowDetail.getBdid());
        borrowDetail.setFpic(fpic);
        borrowDetail.setYpic(ypic);
        borrowDetail.setTpic(tpic);
        borrowDetail.setQpic(qpic);
        borrowDetailService.updateTupian(borrowDetail);
        request.setAttribute("borrowApply",borrowApply);
        request.setAttribute("borrowDetail",borrowDetail);
        request.setAttribute("exist","恭喜你，申请成功，我们将在一个工作日内进行审核！");
        return "user/userindex";
    }


    @RequestMapping("/update_page")
    public String updatePage(HttpServletRequest request,HttpSession session){
        ControllerStatusVO statusVO = null;
        String name=(String)session.getAttribute(Constants.USER_IN_SESSION);
        User user=userService.getByface(name);
        logger.info("用户"+user+"正在操作借款信息");
        BorrowDetailVO borrowDetailVO = (BorrowDetailVO) borrowApplyService.getById(user.getUid());
        List<Bz> bzList = (List)bzService.listAll();
        List<Jklx> jklxList = (List)jklxService.listAll();
        List<Sway> swayList = (List)swayService.listAll();
        request.setAttribute("bzList",bzList);
        request.setAttribute("jklxList",jklxList);
        request.setAttribute("swayList",swayList);
        //如果为空则跳转到申请借款页面
        if(borrowDetailVO==null){
            return "user/borrowapply";
        }
        //如果不为空并且审核未通过才能跳转到修改页面进行修改操作
        if(borrowDetailVO.getUid()!=null && borrowDetailVO.getState() == 3){
            request.setAttribute("borrowDetailVO",borrowDetailVO);
            return "user/update_borrow";
        }
        return "user/update_borrow";
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request,HttpSession session,BorrowDetailVO borrowDetailVO, BorrowApply borrowApply,BorrowDetail borrowDetail){
        logger.info("修改申请借款资料");
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
        return "user/userindex";
    }

    @RequestMapping("updateState/{id}")
    @ResponseBody
    public ControllerStatusVO updateState(@PathVariable("id") Long id, BorrowApply borrowApply,HttpSession session){
        logger.info("后台管理员审核借款人");
        ControllerStatusVO statusVO = null;
        HUser HUser = (HUser)session.getAttribute("HUser");
        borrowApply.setHuid(HUser.getHuid());
        borrowApply.setReason(borrowApply.getReason());
        borrowApply.setBaid(id);
        borrowApply.setState(borrowApply.getState());
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

    @RequestMapping("pager")
    @ResponseBody
    public Pager pager(int pageIndex, int pageSize) {
        logger.info("显示审核列表");
        return borrowApplyService.listPager(pageIndex,pageSize);
    }

    @RequestMapping("pageById")
    @ResponseBody
    public Pager pageById(int pageIndex, int pageSize, HttpSession session) {
        logger.info("前台查看申请借款进度");
        Long id=(Long)session.getAttribute(Constants.USER_ID_SESSION);
        return borrowApplyService.listPagerById(pageIndex,pageSize,id);
    }

    @RequestMapping("shenqin")
    public String shenqin(HttpServletRequest request,HttpSession session){
        Long uid=(Long)session.getAttribute(Constants.USER_ID_SESSION);
        BorrowApply borrowApply = borrowApplyService.shResult(uid);
        if(borrowApply.getHuid()!=null){
            request.setAttribute("borrowApply",borrowApply);
            return  "user/borrow";
        }
        return  "user/borrow";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
