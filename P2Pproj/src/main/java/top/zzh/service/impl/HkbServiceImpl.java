package top.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.bean.Hkb;
import top.zzh.common.Pager;
import top.zzh.dao.HkbDAO;
import top.zzh.query.HkbQuery;
import top.zzh.service.AbstractService;
import top.zzh.service.HkbService;

/**
 * Created by 曾志湖 on 2017/12/22.
 * 还款表
 */
@Service
public class HkbServiceImpl extends AbstractService implements HkbService {

    private HkbDAO hkbDAO;

    @Autowired
    public void setHkbDAO(HkbDAO hkbDAO) {
        super.setBaseDAO(hkbDAO);
        this.hkbDAO = hkbDAO;
    }

    @Override
    public Pager listPager(int pageNo, int pageSize, Long uid) {
        Pager pager = new Pager(pageNo, pageSize);
        pager.setRows(hkbDAO.listPager(pager, uid));
        pager.setTotal(hkbDAO.count(uid));
        return pager;
    }

    @Override
    public void updateHmoney(HkbQuery hkbQuery) {
        hkbDAO.updateHmoney(hkbQuery);
    }
}
