package top.zzh.service;

import org.apache.poi.ss.usermodel.Workbook;
import top.zzh.bean.Recommend;

public interface RecommendService extends BaseService {
    Workbook export(Recommend recommend);
}
