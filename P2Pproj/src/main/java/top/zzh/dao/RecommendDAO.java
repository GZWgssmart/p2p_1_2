package top.zzh.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zzh.common.Pager;

import java.util.List;

/**
 * Created by 谢学培 on 2017/12/21.
 */
@Repository
public interface RecommendDAO extends BaseDAO {
    //不存在：0  存在：1
    int countTzm(@Param("tzm") String tzm);
    @Override
    List<Object> listPagerCriteria(@Param("pager") Pager pager, @Param("query") Object obj);

    @Override
    Long countCriteria(@Param("query") Object obj);

    Object recommendRanking();
}
