package top.zzh.dao;

import org.springframework.stereotype.Repository;
import top.zzh.bean.Jur;

import java.util.List;

/**
 * Created by XIE Shanlin on 2017.12.26.
 */
@Repository
public interface ExcelIntoDAO extends BaseDAO{

    void intoDB(List<Jur> jurList);
    void saveJur(Jur jur);
}
