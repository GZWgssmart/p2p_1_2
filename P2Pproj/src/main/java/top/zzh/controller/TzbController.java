package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.BorrowDetail;
import top.zzh.bean.Tzb;
import top.zzh.bean.User;
import top.zzh.common.Constants;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.TzbService;
import top.zzh.vo.ControllerStatusVO;
import top.zzh.vo.TzbVO;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by 曾志湖 on 2017/12/26.
 * 投资表
 */
@Controller
@RequestMapping("/tz")
public class TzbController {

    private Logger logger = LoggerFactory.getLogger(TzbController.class);
    @Autowired
    private TzbService tzbService;


    @RequestMapping("save")
    @ResponseBody
    public ControllerStatusVO save(User user, Tzb tzb, HttpSession session, BorrowDetail borrowDetail){
        User user1 = (User)session.getAttribute(Constants.USER_IN_SESSION);
        logger.info("用户"+user1.getRname()+"正在开始投资");
        ControllerStatusVO statusVO = null;
        Long userid = (Long)session.getAttribute(Constants.USER_ID_SESSION);
        //获取当前投资用户的id
        tzb.setUid(userid);
        tzb.setJuid(borrowDetail.getBaid());
        tzb.setMoney(tzb.getMoney());
        tzb.setTime(new Date());
        tzb.setNprofit(borrowDetail.getNprofit());
        tzb.setCpname(borrowDetail.getCpname());
        tzb.setBaid(borrowDetail.getBaid());
        tzbService.save(tzb);
        //用户进行投资时，更新投资人的用户资金表，总金额减，可用余额减，投资总额加，待收总额加，更新借款人的用户资金表，总资产加， 可用余额不动，冻结金额加
        

        statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_TZ_SUCCESS);
        return statusVO;
    }
    
    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int pageIndex,int pageSize, TzbVO tzbVO) {
        logger.info("投资信息+条件查询");
        return tzbService.listPagerCriteria(pageIndex, pageSize, tzbVO);
    }

    @RequestMapping("pageById")
    @ResponseBody
    public Pager pageById(int pageIndex, int pageSize, HttpSession session) {
        logger.info("前台用户查看投资进度");
        Long id=(Long)session.getAttribute(Constants.USER_ID_SESSION);
        return tzbService.listPagerById(pageIndex,pageSize,id);
    }



    @RequestMapping("page")
    public String page(){
        logger.info("管理员查看用户投资情况");
        return "manager/tz";
    }
}
