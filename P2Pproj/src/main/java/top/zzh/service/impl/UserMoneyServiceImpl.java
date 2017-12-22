package top.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.dao.UserMoneyDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.UserMoneyService;

/**
 * @author 陈桢
 * created time 2017-12-21 20:44
 */
@Service
public class UserMoneyServiceImpl extends AbstractService implements UserMoneyService {

    private UserMoneyDAO userMoneyDAO;

    @Autowired
    public void setUserMoneyDAO(UserMoneyDAO userMoneyDAO) {
        super.setBaseDAO(userMoneyDAO);
        this.userMoneyDAO = userMoneyDAO;
    }

}
