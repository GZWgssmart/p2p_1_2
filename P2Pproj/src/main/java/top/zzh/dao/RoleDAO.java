package top.zzh.dao;

import org.springframework.stereotype.Repository;
import top.zzh.bean.Role;

import java.util.List;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
@Repository
public interface RoleDAO  extends BaseDAO {

    List<String> listRoles(String username);

    List<Role> list();

}
