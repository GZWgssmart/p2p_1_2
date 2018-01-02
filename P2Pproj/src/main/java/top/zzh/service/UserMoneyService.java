package top.zzh.service;

/**
 * 陈桢
 */
public interface UserMoneyService extends BaseService {

    Long getMoney(String uid);

    void updateMoney(String money,String uid);

}
