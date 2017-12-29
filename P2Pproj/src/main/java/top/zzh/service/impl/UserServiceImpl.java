package top.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.bean.User;
import top.zzh.dao.UserDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.UserService;

/**
 * Created by 曾志湖 on 2017/12/21.
 * 前台用户表
 */

@Service
public class UserServiceImpl extends AbstractService implements UserService{



    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        super.setBaseDAO(userDAO);
        this.userDAO = userDAO;
    }

    @Override
    public User getByNamePwd(String name, String pwd) {
        return userDAO.getByNamePwd(name, pwd);
    }


    @Override
    public User getByPhone(String phone) {
        return userDAO.getByPhone(phone);
    }

    @Override
    public Long register(Object obj) {
        return userDAO.register(obj);
    }

    @Override
    public void saveHeader(String face,String uname) {
        userDAO.saveHeader(face,uname);
    }

    @Override
    public User getByface(String uname) {
        return userDAO.getByface(uname);
    }
}
