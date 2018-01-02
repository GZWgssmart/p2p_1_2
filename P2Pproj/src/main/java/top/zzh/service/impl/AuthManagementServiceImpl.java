package top.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.bean.Jur;
import top.zzh.common.Pager;
import top.zzh.dao.AuthManagementDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.AuthManagementService;

/**
 * Created by XIE Shanlin on 2018.01.02.
 */
@Service
public class AuthManagementServiceImpl extends AbstractService implements AuthManagementService{

    private AuthManagementDAO authManagementDAO;

    @Autowired
    public void setAuthManagementDAO(AuthManagementDAO authManagementDAO) {
        super.setBaseDAO(authManagementDAO);
        this.authManagementDAO = authManagementDAO;
    }

    @Override
    public Pager permissionListPagerCriteria(int pageNo, int pageSize, Object obj) {
        Pager pager = new Pager(pageNo, pageSize);
        pager.setRows(authManagementDAO.permissionListPagerCriteria(pager,obj));
        pager.setTotal(authManagementDAO.permissionCountCriteria(obj));
        return pager;
    }

    @Override
    public void addPermission(Jur jur) {
        authManagementDAO.addPermission(jur);
    }

    @Override
    public void updatePermission(Jur jur) {
        authManagementDAO.updatePermission(jur);
    }
}
