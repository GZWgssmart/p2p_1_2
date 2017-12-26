package top.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.common.Pager;
import top.zzh.dao.LoginLogDAO;
import top.zzh.service.LoginLogService;

import java.util.List;

/**
 * Created by Administrator on 2017/12/7 0007.
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogDAO loginLogDAO;

    @Override
    public void save(Object obj) {

        loginLogDAO.save(obj);
    }

    @Override
    public void remove(Object obj) {
        loginLogDAO.remove(obj);
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void update(Object obj) {

    }

    @Override
    public Object getById(Long id) {
        return null;
    }

    @Override
    public List<Object> listAll() {
        return null;
    }

    @Override
    public Pager listPager(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public Pager listPagerCriteria(int pageNo, int pageSize, Object obj) {
        return null;
    }


    @Override
    public long getByName(String name) {

        return loginLogDAO.getByName(name);
    }
}
