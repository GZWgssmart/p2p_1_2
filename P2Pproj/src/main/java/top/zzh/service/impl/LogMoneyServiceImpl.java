package top.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.dao.LogMoneyDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.LogMoneyService;

/**
 * Created by 曾志湖 on 2017/12/22.
 */
@Service
public class LogMoneyServiceImpl extends AbstractService implements LogMoneyService{

    private LogMoneyDAO logMoneyDAO;

    @Autowired
    public void setLogMoneyDAO(LogMoneyDAO logMoneyDAO) {
        super.setBaseDAO(logMoneyDAO);
        this.logMoneyDAO = logMoneyDAO;
    }
}
