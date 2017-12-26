package top.zzh.service;


import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/12/7 0007.
 */
public interface LoginLogService extends BaseService {
    long getByName(String name);
}
