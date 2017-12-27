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
import top.zzh.vo.RecommendVO;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by 谢学培 on 2017/12/21.
 */
@Service
public class RecommendServiceImpl extends AbstractService implements RecommendService {

    private RecommendDAO recommendDAO;

    @Autowired
    public void setRecommendDAO(RecommendDAO recommendDAO) {
        super.setBaseDAO(recommendDAO);
        this.recommendDAO = recommendDAO;
    }

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

}
