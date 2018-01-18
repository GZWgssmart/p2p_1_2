package top.zzh.service;

import top.zzh.bean.Hkb;
import top.zzh.common.Pager;
import top.zzh.query.HkbQuery;

/**
 * Created by 曾志湖 on 2017/12/22.
 */

public interface HkbService extends BaseService {
    Pager listPager(int pageNo, int pageSize, Long uid);

    void updateHmoney(HkbQuery hkbQuery);
}
