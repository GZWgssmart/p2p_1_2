package top.zzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.Reward;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.query.RewardQuery;
import top.zzh.service.RewardService;
import top.zzh.service.UserMoneyService;
import top.zzh.vo.ControllerStatusVO;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Controller
@RequestMapping("/reward")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @Autowired
    private UserMoneyService userMoneyService;

    @RequestMapping("rewardList")
    public String rewardList(){
        return  "manager/RewardList";
    }

    @RequestMapping("pager")
    @ResponseBody
    public Pager pager(int pageIndex, int pageSize, RewardQuery rewardQuery) {

        return rewardService.listPagerCriteria(pageIndex,pageSize,rewardQuery);
    }

    @PostMapping("updateState/{uid}/{state}/{money}")
    @ResponseBody
    public ControllerStatusVO updateState(@PathVariable("uid")Long uid, @PathVariable("state") Integer state, @PathVariable("money")BigDecimal money){
        ControllerStatusVO statusVO=null;

        Calendar calendar=Calendar.getInstance();
        Reward reward4=new Reward();
        reward4.setUid(uid);
        reward4.setState((byte)2);
        reward4.setDate(calendar.getTime());
        rewardService.updateState(reward4);

        userMoneyService.updateJlmoney(money,uid);

        statusVO = ControllerStatusVO.status(ControllerStatusEnum.SWAY_UPDATE_STATE_SUCCESS);
        return statusVO;
    }

}
