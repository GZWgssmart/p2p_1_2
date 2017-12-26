package top.zzh.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/12/7 0007.
 */
@Repository
public interface LoginLogDAO extends BaseDAO {

    long getByName(@Param("name") String name);

}
