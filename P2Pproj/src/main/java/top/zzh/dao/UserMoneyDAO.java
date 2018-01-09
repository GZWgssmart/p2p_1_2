package top.zzh.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zzh.bean.UserMoney;
import top.zzh.common.Pager;

import java.math.BigDecimal;
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

    UserMoney findJlmoney(@Param("uid") Long uid);

    void updateJlmoney(@Param("jlmoney")BigDecimal jlmoney,@Param("uid")Long uid);
}
