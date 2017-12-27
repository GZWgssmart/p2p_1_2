package top.zzh.service;

import top.zzh.bean.HUser;
import top.zzh.bean.User;

/**
 * Created by 赖勇健 on 2017/12/21.
 */
public interface HuserService extends BaseService {
    HUser getByNamePwd(String phone, String pwd);

    HUser getByPhone(String phone);
    Long  register(Object obj);

}
