package top.zzh.service;

import top.zzh.bean.UserMoney;
import top.zzh.common.Pager;

import java.math.BigDecimal;
import java.util.List;

/**
 * 陈桢
 */
public interface UserMoneyService extends BaseService {

    Long getMoney(String uid);

    Long getZmoney( String uid);

    void updateMoney( String money, String zmoney,String uid);

    UserMoney findJlmoney(Long uid);

    void updateJlmoney(BigDecimal jlmoney,Long uid);
    Object getByUserId(Long id);

    Pager listPagerUid(int pageNo,int pageSize, Object obj);

    Long getCount(Object obj);
}
