package top.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.common.Pager;
import top.zzh.dao.UserTicketDAO;
import top.zzh.service.AbstractService;
import top.zzh.service.UserTicketService;
import top.zzh.vo.UserTicketVo;

import java.util.List;
@Service
public class UserTicketServiceImpl extends AbstractService implements UserTicketService {
    private UserTicketDAO userTicketDAO;
    @Autowired
    public void setUserTicketDAO(UserTicketDAO userTicketDAO) {
        super.setBaseDAO(userTicketDAO);
        this.userTicketDAO = userTicketDAO;
    }

    @Override
    public List<UserTicketVo> unuse(Long uid) {
        return userTicketDAO.unuse(uid);
    }

    @Override
    public List<UserTicketVo> used(Long uid) {
        return userTicketDAO.used(uid);
    }

    @Override
    public List<UserTicketVo> overed(Long uid) {
        return userTicketDAO.overed(uid);
    }

    @Override
    public Integer unuseCount(Long uid) {
        return userTicketDAO.unuseCount(uid);
    }

    @Override
    public Integer usedCount(Long uid) {
        return userTicketDAO.usedCount(uid);
    }

    @Override
    public Integer overedCount(Long uid) {
        return userTicketDAO.overedCount(uid);
    }
}
