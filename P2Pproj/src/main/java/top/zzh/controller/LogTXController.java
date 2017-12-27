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
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.LogTxService;
import top.zzh.vo.ControllerStatusVO;
import top.zzh.vo.LogTxVO;

@RequestMapping("/logTx")
@Controller
public class LogTXController {

    @Autowired
    private LogTxService logTxService;

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

    @PostMapping("pager_criteria")
    @ResponseBody
    public Pager listPager(int pageIndex, int pageSize,LogTxVO logTx){

        return logTxService.listPagerCriteria(pageIndex,pageSize,logTx);
    }
}
