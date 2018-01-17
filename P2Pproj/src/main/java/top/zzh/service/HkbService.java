package top.zzh.service;

import top.zzh.common.Pager;
import top.zzh.vo.HkbVO;

/**
 * Created by 曾志湖 on 2017/12/22.
 */

public interface HkbService extends BaseService {

    Pager find(int pageNo,int pageSize,Object object);
}
