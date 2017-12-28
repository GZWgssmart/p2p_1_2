package top.zzh.controller;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.LogTx;
import top.zzh.bean.UserMoney;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.LogTxService;
import top.zzh.service.UserMoneyService;
import top.zzh.vo.ControllerStatusVO;
import top.zzh.vo.LogTxVO;
import top.zzh.vo.UserMoneyVO;

/**
 * Cander 陈桢 2017/12/28
 */
@RequestMapping("/userMoney")
@Controller
public class UserMoneyController {

    @Autowired
    private UserMoneyService userMoneyService;

    private ControllerStatusVO statusVO;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(LogMoneyController.class);

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
