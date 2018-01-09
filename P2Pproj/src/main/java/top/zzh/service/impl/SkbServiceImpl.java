package top.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.bean.Skb;
import top.zzh.bean.Tzb;
import top.zzh.calculator.*;
import top.zzh.common.Pager;
import top.zzh.dao.BorrowDetailDAO;
import top.zzh.dao.SkbDAO;
import top.zzh.dao.TzbDAO;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.AbstractService;
import top.zzh.service.SkbService;
import top.zzh.vo.BorrowDetailVO;
import top.zzh.vo.ControllerStatusVO;
import top.zzh.vo.TzbVO;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by 曾志湖 on 2017/12/22.
 * 收款表
 */
@Service
public class SkbServiceImpl extends AbstractService implements SkbService{

    private SkbDAO skbDAO;
    private BorrowDetailDAO borrowDetailDAO;
    private TzbDAO tzbDAO;
    private Loan loan;

    @Autowired
    public void setSkbDAO(SkbDAO skbDAO) {
        super.setBaseDAO(skbDAO);
        this.skbDAO = skbDAO;
    }

    @Override
    public Pager skblist(int pageNo, int pageSize, Long uid, Long baid) {
        Pager pager = new Pager(pageNo,pageSize);
        pager.setRows(skbDAO.list(pager,uid,baid));
        pager.setTotal(skbDAO.countUid(uid,baid));
        return pager;
    }

    public ControllerStatusVO saveSkb(Long uid, Long baid){
        ControllerStatusVO statusVO = null;
        //装载保存收款表的list
        List<Skb> skbList = new ArrayList<>();
        //根据用户id 和借款id查出所有的金额
        BorrowDetailVO borrowDetailVO = (BorrowDetailVO)borrowDetailDAO.getById(baid);
        //根据用户id和收款表的id去查询有没有记录
        Long count = skbDAO.countUid(uid,baid);
        //如果没有收款记录则生成
        if(count==0){
            //如果当前借款的目标金额和已筹金额相等
            if(borrowDetailVO.getMoney().compareTo(borrowDetailVO.getMmoney())==0){
                //则查询出该用户对该借款投资了几次
                List<Tzb> tzbList = tzbDAO.listTzb(uid,baid);
                //计算出总投资金额
                //计算出总投资金额
                BigDecimal money = new BigDecimal(0);
                for (Tzb tzb : tzbList) {
                    money = money.add(tzb.getMoney());
                }
                Tzb tzb = tzbList.get(0);
                if(tzb.getInt2() == 1) {
                    ACPIMLoanCalculator calculator = new ACPIMLoanCalculator();
                    loan = calculator.calLoan(LoanUtil.totalLoanMoney(money, 0), tzb.getInt1(), LoanUtil.rate(tzb.getNprofit(), 1), LoanUtil.RATE_TYPE_YEAR);
                }else if(tzb.getInt2() == 2){
                    ACMLoanCalculator calculator = new ACMLoanCalculator();
                    loan = calculator.calLoan(LoanUtil.totalLoanMoney(money, 0), tzb.getInt1(), LoanUtil.rate(tzb.getNprofit(), 1), LoanUtil.RATE_TYPE_YEAR);
                }
                for (LoanByMonth loanByMonth : loan.getAllLoans()) {
                    Skb skb = new Skb();
                    skb.setUid(uid);
                    skb.setJuid(tzb.getJuid());
                    skb.setBaid(baid);
                    skb.setYbx(loanByMonth.getRepayment());
                    skb.setRbx(new BigDecimal(0));
                    skb.setYlx(loanByMonth.getInterest());
                    skb.setRlx(new BigDecimal(0));
                    skb.setYbj(loanByMonth.getPayPrincipal());
                    skb.setRbj(new BigDecimal(0));
                    skb.setTnum(tzb.getInt1());
                    skbList.add(skb);
                }
                skbDAO.saveList(skbList);

            }
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CHECK_TZ_FAILED);
        }
        return statusVO;
    }

    @Autowired
    public void setBorrowDetailDAO(BorrowDetailDAO borrowDetailDAO) {
        this.borrowDetailDAO = borrowDetailDAO;
    }

    @Autowired
    public void setTzbDAO(TzbDAO tzbDAO) {
        this.tzbDAO = tzbDAO;
    }
}
