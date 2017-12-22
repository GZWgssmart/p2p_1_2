package top.zzh.service.impl;

import org.springframework.stereotype.Service;
import top.zzh.dao.ShBorrowDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.ShBorrowService;

/**
 * Created by 曾志湖 on 2017/12/22.
 * 借款审核表
 */
@Service
public class ShBorrowServiceImpl extends AbstractService implements ShBorrowService{

    private ShBorrowDAO shBorrowDAO;

    public void setShBorrowDAO(ShBorrowDAO shBorrowDAO) {
        super.setBaseDAO(shBorrowDAO);
        this.shBorrowDAO = shBorrowDAO;
    }
}
