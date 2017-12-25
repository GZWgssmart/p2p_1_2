package top.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.service.AbstractService;
import top.zzh.service.SwayService;

/**
 * @version :1.0
 * CREATE TIME :2017/12/25 14:33
 * @authro :LH
 */
@Service
public class SwaySeriveImpl extends AbstractService implements SwayService {
    private SwayService swayService;

    @Autowired
    public void setSwayService(SwayService swayService) {
        super.setBaseDAO(swayService);
        this.swayService = swayService;
    }
}
