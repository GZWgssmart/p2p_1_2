package top.zzh.service;

import top.zzh.vo.UserTicketVo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserTicketService extends BaseService{
    List<UserTicketVo> unuse(Long uid);
    List<UserTicketVo> used(Long uid);
    List<UserTicketVo> overed(Long uid);

    Integer unuseCount(Long uid);
    Integer usedCount(Long uid);
    Integer overedCount(Long uid);
    void regTktsave(Long uid);
    List<UserTicketVo> selectUtkListByName(String tname,Long uid);
    public void updateEGold();
}
