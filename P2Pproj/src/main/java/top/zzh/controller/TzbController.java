package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.Reward;
import top.zzh.bean.Tzb;
import top.zzh.bean.UserMoney;
import top.zzh.common.Constants;
import top.zzh.common.JLff;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.*;
import top.zzh.vo.BorrowDetailVO;
import top.zzh.vo.ControllerStatusVO;
import top.zzh.vo.TzbVO;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


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

    @Autowired
    private RewardService rewardService;

    private BorrowApplyService borrowApplyService;
    @Autowired
    private BorrowDetailService borrowDetailService;
    @Autowired
    private UserMoneyService userMoneyService;

    @RequestMapping("save")
    public String save(Tzb tzb, HttpSession session,Object obj){
        //用户如果没有登录则跳转到登录页面，如果登录则可以进行投资
        if (session.getAttribute(Constants.USER_IN_SESSION) == null || session.getAttribute(Constants.USER_IN_SESSION) == "") {
            return "user/nopower";
        }else{
            String name = (String) session.getAttribute(Constants.USER_IN_SESSION);
            logger.info("用户"+name+"正在开始投资");
            ControllerStatusVO statusVO = null;
            Long userid = (Long)session.getAttribute(Constants.USER_ID_SESSION);
            TzbVO tzbVO = (TzbVO)obj;
            BorrowDetailVO borrowDetailVO = (BorrowDetailVO)borrowDetailService.getById(tzbVO.getBaid());
            if (borrowDetailVO.getUid().equals(tzbVO.getUid())){
                statusVO = ControllerStatusVO.status(ControllerStatusEnum.CHECK_TZ_FAIL);
            }
            tzbVO.setJuid(borrowDetailVO.getUid());
            tzbVO.setCpname(borrowDetailVO.getCpname());
            tzbVO.setNprofit(borrowDetailVO.getNprofit());
            tzb.setUid(userid);
            tzbService.save(tzb);
            //用户进行投资时，更新投资人的用户资金表，总金额减，可用余额减，投资总额加，待收总额加，更新借款人的用户资金表，总资产加， 可用余额不动，冻结金额加
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_TZ_SUCCESS);
            //修改投资人的资产
            UserMoney userMoney =(UserMoney) userMoneyService.getById(tzbVO.getUid());
            //如果可用余额小于投资余额，则用户进行充值
            if(userMoney.getKymoney().compareTo(tzbVO.getMoney())==-1){
                statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_MONEY_ENOUGH);
            }
            userMoney.setTzmoney(userMoney.getTzmoney().add(tzbVO.getMoney()));
            //获取投资总额所对应的投资奖励百分比，系统自动添加

            //添加投资奖励

            //更新用户资产
            userMoney.setKymoney(userMoney.getKymoney().subtract(tzbVO.getMoney()));
            //初始化收益
            Float yearNporofit = borrowDetailVO.getNprofit();
            //月利率
            Float monthNprofit = yearNporofit/12;
            BigDecimal symoney = BigDecimal.valueOf(0);
            //一次还清和先息后本的用户收益计息方式
            
            return "user/userindex";
        }
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

    @RequestMapping("ltzView")
    public String ltzView(){
        return "user/tzMoney";
    }

    @PostMapping("ltzSave")
    public String ltzSave(BigDecimal money,HttpSession session){

        Long uid=(Long)session.getAttribute(Constants.USER_ID_SESSION);
        Reward reward=rewardService.findTmoney(uid);

        Timer timer=new Timer();
        Calendar calendar=Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+4,calendar.get(Calendar.DAY_OF_MONTH)
                ,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),0);//calendar.get(Calendar.SECOND)秒
        System.out.println(calendar.getTime().toLocaleString());
        JLff jLff=new JLff();
        Reward reward1=new Reward();
        BigDecimal ymoney=null;
        BigDecimal tmoney=null;
        if(reward==null){
            ymoney=BigDecimal.valueOf(0);
            tmoney=ymoney.add(money);
            reward1.setUid(uid);
            reward1.setMoney(jLff.jlj(money));
            reward1.setState((byte) 1);
            reward1.setTmoney(tmoney);
            reward1.setDate(calendar.getTime());
            rewardService.save(reward1);
        }

        if(reward!=null){
            Reward reward3=new Reward();
            reward3.setUid(uid);
            reward3.setState((byte)1);
            reward3.setDate(calendar.getTime());
            rewardService.updateState(reward3);
            ymoney=reward.getTmoney();
            tmoney= ymoney.add(money);
            Reward reward2=new Reward();
            reward2.setUid(uid);
            reward2.setTmoney(tmoney);
            BigDecimal jl=reward.getMoney();
            BigDecimal zjl=jl.add(jLff.jlj(money));
            reward2.setMoney(zjl);
            rewardService.updateTjmoney(reward2);
        }


        System.out.println("奖励金=="+jLff.jlj(money));
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                System.out.println("定时任务启动！");
                Reward reward5=rewardService.findTmoney(uid);
                if(reward5.getState()==1){
                    Reward reward4=new Reward();
                    reward4.setUid(uid);
                    reward4.setState((byte)2);
                    reward4.setDate(calendar.getTime());
                    rewardService.updateState(reward4);

                    UserMoney userMoney=userMoneyService.findJlmoney(uid);
                    BigDecimal xjlmoney=jLff.jlj(money);
                    BigDecimal yjlmoney=null;
                    BigDecimal jlmoney=null;
                    if(userMoney==null){
                        yjlmoney=BigDecimal.valueOf(0);
                        jlmoney=yjlmoney.add(xjlmoney);
                    }

                    if(userMoney!=null){
                        yjlmoney=userMoney.getJlmoney();
                        jlmoney=yjlmoney.add(xjlmoney);
                    }

                    userMoneyService.updateJlmoney(jlmoney,uid);
                }

            }
        },calendar.getTime());


        return "user/login";
    }


}
