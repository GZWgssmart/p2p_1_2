package top.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.dao.NoticeDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.NoticeService;

/**
 * @version :1.0
 * CREATE TIME :2018/1/1 19:52
 * @authro :LH
 */
@Service
public class NoticeServiceImpl extends AbstractService implements NoticeService {

    private NoticeDAO noticeDAO;
    @Autowired
    public void setNoticeDAO(NoticeDAO noticeDAO) {
        super.setBaseDAO(noticeDAO);
        this.noticeDAO = noticeDAO;
    }
}
