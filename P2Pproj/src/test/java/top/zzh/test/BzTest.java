package top.zzh.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.zzh.bean.Bz;
import top.zzh.bean.Sway;
import top.zzh.common.Pager;
import top.zzh.dao.BzDAO;
import top.zzh.dao.SwayDAO;

import java.util.List;

/**
 * @Cander 陈桢 2017/12/25
 */
public class BzTest extends BaseTest {
    @Autowired
    private BzDAO BzDAO;


    @Test
    public void save(){
       Bz bz =new Bz();
       bz.setBzname("zz");
       bz.setState((byte)0);
        BzDAO.save(bz);
    }

    @Test
    public void update(){
        Bz bz = new Bz();
        bz.setBzname("zzz");
        bz.setState((byte)0);
        bz.setBzid(1L);
        BzDAO.update(bz);
    }

    @Test
    public void updateState(){
        Bz bz = new Bz();
        bz.setState((byte)1);
        bz.setBzid(1L);
        BzDAO.updateState(bz);
    }

    @Test
    public void removeById(){
        Long bzid = 1L;
        BzDAO.removeById(bzid);
    }
    @Test
    public void listPager(){
        Pager pager=new Pager(1,2);
        List<Object> objectList=BzDAO.listPager(pager);
        for(Object obj:objectList){
            Bz bz = (Bz)obj;
            System.out.println(bz.getBzname());
        }
    }


}
