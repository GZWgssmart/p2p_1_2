package top.zzh.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.zzh.bean.BorrowApply;
import top.zzh.common.Pager;
import top.zzh.dao.BorrowApplyDAO;
import top.zzh.vo.BorrowDetailVO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by 曾志湖 on 2017/12/25.
 */
public class BorrowApplyTest extends BaseTest {

    @Autowired
    private BorrowApplyDAO borrowApplyDAO;

    @Test
    public void save(){
        BorrowApply borrowApply = new BorrowApply();
        borrowApply.setRname("张三");
        borrowApply.setMoney(BigDecimal.valueOf(1500));
        borrowApply.setUid(4L);
        borrowApply.setBzid(1L);
        borrowApply.setState((byte)0);
        borrowApply.setTerm(5);
        borrowApply.setType((byte)1);
        borrowApply.setDeadline(new Date());
        borrowApplyDAO.save(borrowApply);
    }

    @Test
    public void update(){
        BorrowApply borrowApply = new BorrowApply();
        borrowApply.setBaid(1L);
        borrowApply.setRname("李四");
        borrowApplyDAO.update(borrowApply);
    }

    @Test
    public void listAll(){
        List<Object> objectList=borrowApplyDAO.listAll();
        for(Object obj:objectList){
            BorrowApply borrowDetailVO=(BorrowApply) obj;
            System.out.println(borrowDetailVO.getRname());
        }
    }

    @Test
    public void listPager(){
        Pager pager=new Pager(1,2);
        List<Object> objectList=borrowApplyDAO.listPager(pager);
        for(Object obj:objectList){
            BorrowApply borrowDetailVO=(BorrowApply) obj;
            System.out.println(borrowDetailVO.getRname());
        }
    }

    @Test
    public void  listPagerCriteria(){
        BorrowApply borrowApply =new BorrowApply();
        BigDecimal bigDecimal=new BigDecimal(1500);
        borrowApply.setMoney(bigDecimal);
        Pager pager=new Pager(1,2);
        List<Object> objectList=borrowApplyDAO.listPagerCriteria(pager,borrowApply);
        for(Object obj:objectList){
            BorrowApply borrowApply1=(BorrowApply) obj;
            System.out.println(borrowApply1.getMoney());
        }
    }

}
