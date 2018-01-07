package top.zzh.service;

import top.zzh.bean.Permission;
import top.zzh.common.Pager;

/**
 * Created by XIE Shanlin on 2018.01.02.
 */

public interface PermissionService extends BaseService{

    //权限
    Pager permissionListPagerCriteria(int pageNo, int pageSize, Object obj);
    void addPermission(Permission permission);
    void updatePermission(Permission permission);

}
