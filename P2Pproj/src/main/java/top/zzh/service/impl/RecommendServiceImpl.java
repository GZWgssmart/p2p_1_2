package top.zzh.service.impl;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.bean.Recommend;
import top.zzh.bean.User;
import top.zzh.common.Pager;
import top.zzh.dao.RecommendDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.RecommendService;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by 谢学培 on 2017/12/21.
 */
@Service
public class RecommendServiceImpl extends AbstractService implements RecommendService {
    @Autowired
    private RecommendDAO recommendDAO;

    @Override
    public void save(Object obj) {
        User user = (User) obj;
        int tzm = (int) (Math.random() * 900000 + 100000);
        boolean tzmisExit = true;
        while (tzmisExit) {
            //不存在：0  存在：1
            int isExit = recommendDAO.countTzm(tzm + "");
            if (isExit == 1) {
                tzm = (int) (Math.random() * 900000 + 100000);
            } else if (isExit == 0) {
                tzmisExit = false;
                user.setTzm(tzm + "");
            }
        }
    }

    @Override
    public Pager listPagerCriteria(int pageNo, int pageSize, Object obj) {
//        通过输入【推荐人姓名，被推荐人姓名】来查找分页
        Pager pager = new Pager(pageNo, pageSize);
        pager.setRows(recommendDAO.listPagerCriteria(pager, obj));
        pager.setTotal(recommendDAO.countCriteria(obj));
        return pager;
    }

    @Override
    public Workbook export(Recommend recommend) {
        Pager pager = new Pager(1, recommendDAO.countCriteria(recommend).intValue());
        List<Object> objectList = recommendDAO.listPagerCriteria(pager, recommend);
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("recommend");
        createHeadRow(sheet);
        createContentRows(sheet, objectList);
        return workbook;
    }

    private void createHeadRow(Sheet sheet) {
        Row headRow = sheet.createRow(0);
        headRow.createCell(0).setCellValue("编号");
        headRow.createCell(1).setCellValue("推荐人id");
        headRow.createCell(2).setCellValue("推荐人");
        headRow.createCell(3).setCellValue("被推荐人id");
        headRow.createCell(4).setCellValue("被推荐人姓名");
        headRow.createCell(5).setCellValue("时间");
    }

    private void createContentRows(Sheet sheet, List<Object> objectList) {
        int i = 1;
        for (Object obj : objectList) {
            Recommend recommend = (Recommend) obj;
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(recommend.getId());
            row.createCell(1).setCellValue(recommend.getTid());
            row.createCell(2).setCellValue(recommend.getTname());
            row.createCell(3).setCellValue(recommend.getUid());
            row.createCell(4).setCellValue(recommend.getRname());
            row.createCell(5).setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(recommend.getDate()));
            i++;
        }
    }
}
