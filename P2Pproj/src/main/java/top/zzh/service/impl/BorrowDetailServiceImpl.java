package top.zzh.service.impl;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.bean.BorrowDetail;
import top.zzh.bean.Recommend;
import top.zzh.common.Pager;
import top.zzh.dao.BorrowDetailDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.BorrowDetailService;
import top.zzh.vo.BorrowDetailVO;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by 曾志湖 on 2017/12/22.
 * 借款详情表
 */
@Service
public class BorrowDetailServiceImpl extends AbstractService implements BorrowDetailService {

    private BorrowDetailDAO borrowDetailDAO;

    @Autowired
    public void setBorrowDetailDAO(BorrowDetailDAO borrowDetailDAO) {
        super.setBaseDAO(borrowDetailDAO);
        this.borrowDetailDAO = borrowDetailDAO;
    }

    @Override
    public void updateTupian(Object obj) {
        borrowDetailDAO.updateTupian(obj);
    }
}
