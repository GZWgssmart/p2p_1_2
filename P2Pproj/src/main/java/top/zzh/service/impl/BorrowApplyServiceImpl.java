package top.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.bean.BorrowApply;
import top.zzh.common.Pager;
import top.zzh.dao.BorrowApplyDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.BorrowApplyService;

/**
 * Created by 曾志湖 on 2017/12/24.
 */
@Service
public class BorrowApplyServiceImpl extends AbstractService implements BorrowApplyService{

    private BorrowApplyDAO borrowApplyDAO;

    @Autowired
    public void setBorrowApplyDAO(BorrowApplyDAO borrowApplyDAO) {
        super.setBaseDAO(borrowApplyDAO);
        this.borrowApplyDAO = borrowApplyDAO;
    }

    @Override
    public void updateState(BorrowApply borrowApply) {
        borrowApplyDAO.updateState(borrowApply);
    }

    @Override
    public Pager listPagerById(int pageNo, int pageSize, Long id) {
        Pager pager = new Pager(pageNo,pageSize);
        pager.setRows(borrowApplyDAO.listPagerById(pager,id));
        pager.setTotal(borrowApplyDAO.countById(id));
        return pager;
    }

    @Override
    public Pager shResult(int pageNo, int pageSize, Long uid) {
        Pager pager = new Pager(pageNo,pageSize);
        pager.setRows(borrowApplyDAO.shResult(pager,uid));
        pager.setTotal(borrowApplyDAO.shCount(uid));
        return pager;
    }

    @Override
    public Long shCount(Long uid) {
        return borrowApplyDAO.shCount(uid);
    }

}
