package top.zzh.service;


import top.zzh.bean.Role;

import java.util.List;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public interface RoleService extends BaseService {
    List<String> listRoles(String username);


    void addRole(Role role);
    void updateRole(Role role);
    void updateStatus(Long roleId,Integer status);

}
