package top.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.zzh.dao.TzbDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.TzbService;

/**
 * Created by 曾志湖 on 2017/12/22.
 * 投资表
 */
public class TzbServiceImpl extends AbstractService implements TzbService{

    private TzbDAO tzbDAO;

    @Autowired
    public void setTzbDAO(TzbDAO tzbDAO) {
        super.setBaseDAO(tzbDAO);
        this.tzbDAO = tzbDAO;
    }
}
