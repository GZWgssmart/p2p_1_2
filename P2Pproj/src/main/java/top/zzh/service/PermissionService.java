package top.zzh.service;

import org.springframework.stereotype.Service;
import top.zzh.bean.Jur;
import top.zzh.bean.Role;
import top.zzh.common.Pager;

/**
 * Created by XIE Shanlin on 2018.01.02.
 */

public interface PermissionService extends BaseService{

    //权限
    Pager permissionListPagerCriteria(int pageNo, int pageSize, Object obj);
    void addPermission(Jur jur);
    void updatePermission(Jur jur);

}
