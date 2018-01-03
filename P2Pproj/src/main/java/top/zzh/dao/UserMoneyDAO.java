package top.zzh.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zzh.common.Pager;

import java.util.List;

/**
 * 陈桢
 */
@Repository
public interface UserMoneyDAO extends BaseDAO {
    @Override
    List <Object> listPagerCriteria(@Param("pager") Pager pager,@Param("query") Object obj);

    @Override
    Long countCriteria(@Param("query") Object obj);

    Long getMoney(@Param("uid") String uid);

    void updateMoney(@Param("money") String money,@Param("uid") String uid);
}
