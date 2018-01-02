package top.zzh.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zzh.bean.Jur;
import top.zzh.common.Pager;

import java.util.List;

/**
 * Created by XIE Shanlin on 2018.01.02.
 */
@Repository
public interface AuthManagementDAO extends BaseDAO {


    List<Object> permissionListPagerCriteria(@Param("pager") Pager pager, @Param("query") Object obj);
    Long permissionCountCriteria(@Param("query") Object obj);

    void addPermission(Jur jur);
    void updatePermission(Jur jur);

}
