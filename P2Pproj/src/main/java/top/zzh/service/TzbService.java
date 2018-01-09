package top.zzh.service;

import top.zzh.common.Pager;
import top.zzh.vo.ControllerStatusVO;

/**
 * Created by 曾志湖 on 2017/12/22.
 * 投资表service
 */
public interface TzbService extends BaseService {

    Pager listPagerById(int pageNo, int pageSize, Long id);
    ControllerStatusVO add(Object obj);
}
