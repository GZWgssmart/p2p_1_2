package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.BankCard;
import top.zzh.bean.User;
import top.zzh.common.Constants;
import top.zzh.common.EncryptUtils;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.BankCardService;
import top.zzh.service.UserService;
import top.zzh.vo.ControllerStatusVO;

import javax.servlet.http.HttpSession;

/**
 * Created by 曾志湖 on 2017/12/24.
 */
@Controller
@RequestMapping("/bankcard")
public class BankCardController {

    private Logger logger = LoggerFactory.getLogger(BankCardController.class);

    @Autowired
    private BankCardService bankCardService;

    @Autowired
    private UserService userService;

    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int page, int rows, BankCard bankCard) {
        logger.info("绑卡信息分页+条件查询");
        return bankCardService.listPagerCriteria(page, rows, bankCard);
    }

    @RequestMapping("save")
    @ResponseBody
    public ControllerStatusVO save(BankCard bankCard, String pwd, HttpSession session){
        logger.info("绑定银行卡");
        Long uid=(Long) session.getAttribute(Constants.USER_ID_SESSION);
        ControllerStatusVO statusVO = null;
        Long lo=(Long)bankCardService.countDank(uid);
        if (lo==1){//已经绑定银行卡
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.UERS_BANK_FAIL);
            return  statusVO;
        }

        User user =(User)session.getAttribute("users");
        bankCard.setUid(uid);
        bankCard.setRname(user.getRname());
        bankCard.setIdno(user.getIdno());
        bankCard.setState((byte)0);
        try{
            bankCardService.save(bankCard);
            userService.updatepwd(uid,EncryptUtils.md5(pwd));//支付密码
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.UERS_BANK_SUCCESS);
        }catch (RuntimeException e){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.UERS_ERROR_FAIL);
        }
        return statusVO;
    }

    @RequestMapping("remove")
    @ResponseBody
    public ControllerStatusVO remove(@PathVariable("bcid") Long bcid){
        logger.info("删除绑定的银行卡");
        ControllerStatusVO statusVO = null;
        try{
            bankCardService.removeById(bcid);
        }catch (RuntimeException e){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_DELETE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_DELETE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("update")
    @ResponseBody
    public ControllerStatusVO update(BankCard bankCard){
        logger.info("修改绑定的银行卡");
        ControllerStatusVO statusVO = null;
        try{
            bankCardService.update(bankCard);
        }catch (RuntimeException e){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_UPDATE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_UPDATE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("updateState")
    @ResponseBody
    public ControllerStatusVO updateState(BankCard bankCard){
        logger.info("修改绑定的银行卡的状态");
        ControllerStatusVO statusVO = null;
        try{
            bankCardService.updateState(bankCard);
        }catch (RuntimeException e){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_ACTIVE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_ACTIVE_SUCCESS);
        return statusVO;
    }
}
