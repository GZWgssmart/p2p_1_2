package top.zzh.service;

import top.zzh.bean.BorrowApply;

/**
 * Created by 曾志湖 on 2017/12/24.
 */
public interface BorrowApplyService extends BaseService{

    //修改审核状态
    void updateState(BorrowApply borrowApply);
}
