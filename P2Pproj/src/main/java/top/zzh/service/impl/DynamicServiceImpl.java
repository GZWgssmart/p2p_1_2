package top.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.dao.DynamicDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.DynamicService;
/**
 * create by 谭芳芳 on 2017/12/21
 * */
@Service
public class DynamicServiceImpl extends AbstractService implements DynamicService{

    private DynamicDAO dynamicDAO;

    @Autowired
    public void setDynamicDAO(DynamicDAO dynamicDAO) {
        super.setBaseDAO(dynamicDAO);
        this.dynamicDAO = dynamicDAO;
    }
}