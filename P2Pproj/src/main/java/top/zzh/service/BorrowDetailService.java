package top.zzh.service;

import org.apache.poi.ss.usermodel.Workbook;
import top.zzh.vo.BorrowDetailVO;

/**
 * Created by 曾志湖 on 2017/12/22.
 */
public interface BorrowDetailService extends BaseService {

    Workbook export(BorrowDetailVO borrowDetailVO);
}
