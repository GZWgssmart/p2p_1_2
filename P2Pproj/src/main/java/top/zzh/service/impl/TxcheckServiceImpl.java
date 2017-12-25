package top.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.dao.TxCheckDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.TxcheckService;

/**
 * cander 陈桢 2017/12/22
 */
@Service
public class TxcheckServiceImpl extends AbstractService implements TxcheckService {

    private TxCheckDAO txCheckDAO;

    @Autowired
    public void setTxCheckDAO(TxCheckDAO txCheckDAO) {
        super.setBaseDAO(txCheckDAO);
        this.txCheckDAO = txCheckDAO;
    }
}
