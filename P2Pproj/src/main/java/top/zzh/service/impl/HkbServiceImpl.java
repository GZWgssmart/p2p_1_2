package top.zzh.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.common.Pager;
import top.zzh.dao.HkbDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.HkbService;
import top.zzh.vo.HkbVO;

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
    public Pager find(int pageNo, int pageSize, Object object) {
        Pager pager =new Pager(pageNo,pageSize);
        pager.setRows(hkbDAO.find(pager, object));
        pager.setTotal(hkbDAO.countByUid(object));
        return pager;
    }
}
