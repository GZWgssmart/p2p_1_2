package top.zzh.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zzh.bean.User;

@Repository
public interface UserDAO extends BaseDAO {

    User getByNamePwd(@Param("name") String name, @Param("pwd") String pwd);

    User getByPhone(@Param("phone")String phone);

    Long  register(Object obj);
}
