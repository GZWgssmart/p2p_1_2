package top.zzh.service.impl;

import org.springframework.stereotype.Service;
import top.zzh.dao.SkbDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.SkbService;

/**
 * Created by 曾志湖 on 2017/12/22.
 * 收款表
 */
@Service
public class SkbServiceImpl extends AbstractService implements SkbService{

    private SkbDAO skbDAO;

    public void setSkbDAO(SkbDAO skbDAO) {
        super.setBaseDAO(skbDAO);
        this.skbDAO = skbDAO;
    }
}
