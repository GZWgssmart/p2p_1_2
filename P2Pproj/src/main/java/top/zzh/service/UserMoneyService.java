package top.zzh.service;

import top.zzh.bean.UserMoney;

import java.math.BigDecimal;

/**
 * 陈桢
 */
public interface UserMoneyService extends BaseService {

    Long getMoney(String uid);

    void updateMoney(String money,String uid);

    UserMoney findJlmoney(Long uid);

    void updateJlmoney(BigDecimal jlmoney,Long uid);
    Object getByUserId(Long id);
}
