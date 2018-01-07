package top.zzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.Bz;
import top.zzh.bean.Friend;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.FriendService;
import top.zzh.vo.ControllerStatusVO;

/**
 * @version :1.0
 * CREATE TIME :2018/1/2 8:15
 * @authro :LH
 */
@Controller
@RequestMapping("friend")
public class FriendController {
    @Autowired
    private FriendService friendService;

    @RequestMapping("pager")
    @ResponseBody
    public Pager pager(int pageIndex, int pageSize) {
        return friendService.listPager(pageIndex,pageSize);
    }

    @RequestMapping("bz")
    public String init() {
        return "bz/bz";
    }

    @RequestMapping("save")
    @ResponseBody
    public ControllerStatusVO save(Friend friend){
        ControllerStatusVO statusVO = null;
        try {
            friendService.save(friend);
        } catch (RuntimeException e) {
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.FRIEND_SAVE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.FRIEND_SAVE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("update")
    @ResponseBody
    public ControllerStatusVO update(Friend friend){
        ControllerStatusVO statusVO = null;
        try {
            friendService.update(friend);
        } catch (RuntimeException e) {
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.FRIEND_UPDATE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.FRIEND_UPDATE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("delete/{fid}")
    @ResponseBody
    public ControllerStatusVO delete( @PathVariable("fid") Long id){
        ControllerStatusVO statusVO = null;
        try {
           friendService.removeById(id);
        } catch (RuntimeException e) {
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.FRIEND_DELETE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.FRIEND_DELETE_SUCCESS);
        return statusVO;
    }


    @RequestMapping("findFriend/{fid}")
    @ResponseBody
    public Friend findFriend(@PathVariable("fid") Long fid){
        return  (Friend) friendService.getById(fid);
    }



}
