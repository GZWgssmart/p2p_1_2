package top.zzh.service;

import org.apache.ibatis.annotations.Param;
import top.zzh.bean.User;

/**
 * Created by 曾志湖 on 2017/12/21.
 */
public interface UserService extends BaseService {
    User getByNamePwd(String name, String pwd);


    User getByPhone(String phone);
    Long  register(Object obj);

    void saveHeader(String face,String uname);

    User getByface(String uname);

    void updateZpwd(String uname,String zpwd);

    String getByZpwd(String uname);

    void updateUpwd(long uid,String upwd);

}
