package top.zzh.controller;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.LogTx;
import top.zzh.bean.TxCheck;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.LogTxService;
import top.zzh.service.TxcheckService;
import top.zzh.vo.ControllerStatusVO;
import top.zzh.vo.LogTxVO;
import top.zzh.vo.TxCheckVO;

/**
 * Cander 陈桢 2017/12/27
 */
@RequestMapping("/txCheck")
@Controller
public class TxCheckController {

    @Autowired
    private TxcheckService txcheckService;

    private ControllerStatusVO statusVO;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(LogMoneyController.class);

    @PostMapping("save")
    @ResponseBody
    public ControllerStatusVO save(TxCheck txCheck){
        logger.info("新增提现记录！");
        try {
            txcheckService.save(txCheck);
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_SUCCESS);
        }catch (Exception e){
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_FAIL);
        }
        return statusVO;
    }

    @PostMapping("leaveShenHe")
    @ResponseBody
    public ControllerStatusVO leaveShenHe(TxCheck txCheck){
        logger.info("新增提现记录！");
        System.out.println(txCheck.getExcute());
        try {
            txcheckService.update(txCheck);
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.CHECK_USER_SUCCESS);
        }catch (Exception e){
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.CHECK_USER_FAIL);
        }
        return statusVO;
    }

    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager listPager(int pageIndex, int pageSize,TxCheckVO txCheck){

        return txcheckService.listPagerCriteria(pageIndex,pageSize,txCheck);
    }

    @RequestMapping("init")
    public String  list(){

        return "manager/txCheck";
    }
}
