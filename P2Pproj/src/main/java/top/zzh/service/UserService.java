package top.zzh.service;

import top.zzh.bean.User;

/**
 * Created by 曾志湖 on 2017/12/21.
 */
public interface UserService extends BaseService {
    User getByNamePwd(String name, String pwd);

    User getByPhone(String phone);
    Long  register(Object obj);

}
