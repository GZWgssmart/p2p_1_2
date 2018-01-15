package top.zzh.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zzh.bean.Skb;
import top.zzh.common.Pager;
import top.zzh.vo.ControllerStatusVO;

import java.util.List;

/**
 * Created by 曾志湖 on 2017/12/22.
 * 收款表DAO
 */
@Repository
public interface SkbDAO extends BaseDAO{

    @Override
    List<Object> listPager(@Param("pager") Pager pager);

    @Override
    List <Object> listPagerCriteria(@Param("pager") Pager pager, @Param("query") Object obj);

    @Override
    Long countCriteria(@Param("query") Object obj);

    long countUid(@Param("uid") Long uid, @Param("baid") Long baid);

    void saveList(List <Skb> list);

    List<Object> list(@Param("pager") Pager pager, @Param("uid") Long uid, @Param("baid") Long baid);

}
