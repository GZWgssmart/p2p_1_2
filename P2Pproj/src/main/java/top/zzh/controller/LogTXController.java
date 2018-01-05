package top.zzh.controller;


import jdk.internal.instrumentation.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.LogTx;
import top.zzh.bean.TxCheck;
import top.zzh.common.Constants;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.LogTxService;
import top.zzh.service.TxcheckService;
import top.zzh.vo.ControllerStatusVO;
import top.zzh.vo.LogTxVO;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * Cander 陈桢 2017/12/27
 */
@RequestMapping("/logTx")
@Controller
public class LogTXController {

    @Autowired
    private LogTxService logTxService;

    @Autowired
    private TxcheckService txcheckService;

    private ControllerStatusVO statusVO;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(LogMoneyController.class);

    @PostMapping("save")
    @ResponseBody
    public ControllerStatusVO save(LogTx logTx){
        logger.info("新增提现记录！");
        try {
            logTxService.save(logTx);
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_SUCCESS);
        }catch (Exception e){
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_FAIL);
        }
        return statusVO;
    }

    @RequestMapping("tixian")
    @ResponseBody
    public ControllerStatusVO tixian(HttpSession session, String actualMoney) {
        Long id = (Long) session.getAttribute(Constants.USER_ID_SESSION);
        try{
            LogTx logTx=new LogTx();
            logTx.setMoney(BigDecimal.valueOf(Long.valueOf(actualMoney)));
            logTx.setUid(id);
            logTx.setBanktype("建设银行");
            logTx.setBankcard("110221330");
            logTxService.save(logTx);
            TxCheck txCheck =new TxCheck();
            txCheck.setHuid(id);
            txCheck.setTxid(logTx.getId());
            txcheckService.save(txCheck);
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.BORROW_SAVE_WAIT);
        }catch (Exception e){
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.CHECK_ERR_FAIL);
        }
        return statusVO;
    }

    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager listPager(int pageIndex, int pageSize,LogTxVO logTx){

        return logTxService.listPagerCriteria(pageIndex,pageSize,logTx);
    }

    @RequestMapping("init")
    public String  list(){

        return "manager/logTx";
    }
}
