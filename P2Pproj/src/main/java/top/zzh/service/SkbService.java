package top.zzh.service;

import top.zzh.common.Pager;

/**
 * Created by 曾志湖 on 2017/12/22.
 * 收款表service
 */
public interface SkbService extends BaseService{

    Pager skblist(int pageNo, int pageSize, Long uid, Long baid);
}
