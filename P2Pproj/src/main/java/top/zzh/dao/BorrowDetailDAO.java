package top.zzh.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zzh.bean.BorrowDetail;
import top.zzh.common.Pager;

import java.util.List;

/**
 * Created by 曾志湖 on 2017/12/22.
 * 借款详情表dao
 */
@Repository
public interface BorrowDetailDAO extends BaseDAO{

    @Override
    List <Object> listPager(@Param("pager") Pager pager);

    @Override
    List <Object> listPagerCriteria(@Param("pager") Pager pager, @Param("query") Object obj);

    @Override
    Long countCriteria(@Param("pager") Object obj);

    //修改图片
    void updateTupian(Object obj);
}
