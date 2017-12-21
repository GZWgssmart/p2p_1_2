package top.zzh.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.common.Pager;
import top.zzh.dao.UserMoneyDAO;
import top.zzh.service.UserMoneyService;

import java.util.List;

@Service
public class UserMoneyServiceImpl implements UserMoneyService {

    @Autowired
    private UserMoneyDAO userMoneyDAO;

    @Override
    public void save(Object obj) {
        userMoneyDAO.save(obj);
    }

    @Override
    public void remove(Object obj) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void update(Object obj) {
        userMoneyDAO.update(obj);
    }

    @Override
    public Object getById(Long id) {
        return userMoneyDAO.getById(id);
    }

    @Override
    public List<Object> listAll() {
        return null;
    }

    @Override
    public Pager listPager(int pageNo, int pageSize) {
        Pager pager =new Pager(pageNo,pageSize);
        pager.setRows(userMoneyDAO.listPager(pager));
        pager.setTotal(userMoneyDAO.count());
        return pager;
    }

    @Override
    public Pager listPagerCriteria(int pageNo, int pageSize, Object obj) {
        Pager pager=new Pager(pageNo,pageSize);
        pager.setRows(userMoneyDAO.listPagerCriteria(pager,obj));
        pager.setTotal(userMoneyDAO.countCriteria(obj));
        return pager;
    }
}
