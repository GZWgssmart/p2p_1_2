package top.zzh.service;

import org.apache.ibatis.annotations.Param;
import top.zzh.bean.BorrowApply;
import top.zzh.common.Pager;

/**
 * Created by 曾志湖 on 2017/12/24.
 */
public interface BorrowApplyService extends BaseService{

    //修改审核状态
    void updateState(BorrowApply borrowApply);
    Pager listPagerById(int pageNo, int pageSize, Long id);
    BorrowApply shResult(Long uid);
}
