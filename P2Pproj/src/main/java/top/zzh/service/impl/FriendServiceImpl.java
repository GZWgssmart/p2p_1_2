package top.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.dao.FriendDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.FriendService;

/**
 * @version :1.0
 * CREATE TIME :2018/1/1 19:45
 * @authro :LH
 */
@Service
public class FriendServiceImpl extends AbstractService implements FriendService {


    private FriendDAO friendDAO;

    @Autowired
    public void setFriendDAO(FriendDAO friendDAO) {
        super.setBaseDAO(friendDAO);
        this.friendDAO = friendDAO;
    }
}
