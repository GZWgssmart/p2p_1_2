package top.zzh.service;

import top.zzh.common.Pager;
import top.zzh.vo.ControllerStatusVO;
import java.util.*;
/**
 * Created by 曾志湖 on 2017/12/22.
 * 收款表service
 */
public interface SkbService extends BaseService{

    Pager skblist(int pageNo, int pageSize, Long uid, Long baid);

    //后台查看收款表详情
    Pager find(int pageNo,int pageSize,Object object);
}
