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
    public Workbook export(BorrowDetailVO borrowDetailVO) {
        Pager pager = new Pager(1, borrowDetailDAO.countCriteria(borrowDetailVO).intValue());
        List<Object> objectList = borrowDetailDAO.listPagerCriteria(pager, borrowDetailVO);
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("borrowdetal");
        createHeadRow(sheet);
        createContentRows(sheet, objectList);
        return workbook;
    }

    private void createHeadRow(Sheet sheet) {
        Row headRow = sheet.createRow(0);
        headRow.createCell(0).setCellValue("编号");
        headRow.createCell(1).setCellValue("真实姓名");
        headRow.createCell(2).setCellValue("申请金额");
        headRow.createCell(3).setCellValue("标种名称");
        headRow.createCell(4).setCellValue("借款期限");
        headRow.createCell(5).setCellValue("资金用途");
        headRow.createCell(6).setCellValue("还款来源");
        headRow.createCell(7).setCellValue("借款人介绍");
        headRow.createCell(8).setCellValue("项目描述");
        headRow.createCell(9).setCellValue("保障措施");
        headRow.createCell(10).setCellValue("年化收益");
        headRow.createCell(11).setCellValue("收益方式");
        headRow.createCell(12).setCellValue("产品名称");
        headRow.createCell(13).setCellValue("借款人");
        headRow.createCell(14).setCellValue("截止时间");
    }

    private void createContentRows(Sheet sheet, List<Object> objectList) {
        int i = 1;
        for (Object obj : objectList) {
            BorrowDetailVO borrowDetailVO = (BorrowDetailVO) obj;
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(borrowDetailVO.getBdid());
            row.createCell(1).setCellValue(borrowDetailVO.getRname());
            row.createCell(2).setCellValue(borrowDetailVO.getMoney().doubleValue());
            row.createCell(3).setCellValue(borrowDetailVO.getBzname());
            row.createCell(4).setCellValue(borrowDetailVO.getTerm());
            row.createCell(5).setCellValue(borrowDetailVO.getMpurpose());
            row.createCell(6).setCellValue(borrowDetailVO.getHksource());
            row.createCell(7).setCellValue(borrowDetailVO.getSuggest());
            row.createCell(8).setCellValue(borrowDetailVO.getXmdescrip());
            row.createCell(9).setCellValue(borrowDetailVO.getGuarantee());
            row.createCell(10).setCellValue(borrowDetailVO.getNprofit());
            row.createCell(11).setCellValue(borrowDetailVO.getWay());
            row.createCell(12).setCellValue(borrowDetailVO.getCpname());
            row.createCell(13).setCellValue(borrowDetailVO.getUname());
            row.createCell(14).setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(borrowDetailVO.getDeadline()));
            i++;
        }
    }
}
