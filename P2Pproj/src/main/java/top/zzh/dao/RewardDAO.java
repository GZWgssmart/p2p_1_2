package top.zzh.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zzh.bean.Reward;

/**
 * Created by 赖勇健 on 2018/1/8 0008.
 */
@Repository
public interface RewardDAO extends BaseDAO{

    Reward findTmoney(@Param("uid") Long uid);

    void updateState(Reward reward);

    void updateTjmoney(Reward reward);
}
