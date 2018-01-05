package top.zzh.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.LogMoney;
import top.zzh.bean.UserMoney;
import top.zzh.common.Constants;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.LogMoneyService;
import top.zzh.service.UserMoneyService;
import top.zzh.vo.ControllerStatusVO;
import top.zzh.vo.UserMoneyVO;

import javax.servlet.http.HttpSession;

/**
 * Cander 陈桢 2017/12/28
 */
@RequestMapping("/userMoney")
@Controller
public class UserMoneyController {

    @Autowired
    private UserMoneyService userMoneyService;

    @Autowired
    private LogMoneyService logMoneyService;

    private ControllerStatusVO statusVO;

    private Logger logger = LoggerFactory.getLogger(LogMoneyController.class);

    @PostMapping("save")
    @ResponseBody
    public ControllerStatusVO save(UserMoney userMoney){
        logger.info("新增提现记录！");
        try {
            userMoneyService.save(userMoney);
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_SUCCESS);
        }catch (Exception e){
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_FAIL);
        }
        return statusVO;
    }

    @PostMapping("chongzhi")
    @ResponseBody
    public ControllerStatusVO chongzhi(HttpSession session, UserMoney userMoney){
        logger.info("充值！");
        //获取用户Id
        Long id=(Long)session.getAttribute(Constants.USER_ID_SESSION);
        System.out.println("ID:"+id);
        try {
            if(userMoneyService.getMoney(id.toString())!=null){
                //用户当前可用余额
                Long kymoney=userMoneyService.getMoney(id.toString());
                kymoney=userMoney.getKymoney().longValue()+kymoney;
                System.out.println(kymoney.toString());
                userMoneyService.updateMoney(kymoney.toString(),id.toString());//充值
            }else {

                userMoneyService.updateMoney(userMoney.getKymoney().toString(),id.toString());//充值

            }

            //用户资金流向
            LogMoney logMoney =new LogMoney();
            logMoney.setUid(id);
            logMoney.setType((byte)0);
            logMoney.setOut(userMoney.getKymoney());
            logMoneyService.save(logMoney);
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.UESR_CHONG_SUCCESS);
        }catch (Exception e){
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.UESR_CHONG_FAIL);
        }
        return statusVO;
    }

    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager listPager(int pageIndex, int pageSize,UserMoneyVO userMoney){
        logger.info("用户资金分页！");
        return userMoneyService.listPagerCriteria(pageIndex,pageSize,userMoney);
    }

    @RequestMapping("init")
    public String  list(){

        return "manager/userMoney";
    }
}
