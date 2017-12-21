package top.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.dao.BaseDAO;
import top.zzh.dao.UserDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.UserService;

/**
 * Created by 曾志湖 on 2017/12/21.
 */

@Service
public class UserServiceImpl extends AbstractService implements UserService{


    private UserDAO userDAO;


    public void setBaseDAO(BaseDAO baseDAO) {
        super.setBaseDAO(baseDAO);
        this.userDAO = userDAO;
    }
}
