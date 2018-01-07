package top.zzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.Friend;
import top.zzh.bean.Notice;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.NoticeService;
import top.zzh.vo.ControllerStatusVO;

/**
 * @version :1.0
 * CREATE TIME :2018/1/2 11:16
 * @authro :LH
 */
@Controller
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("pager")
    @ResponseBody
    public Pager pager(int pageIndex, int pageSize) {
        return noticeService.listPager(pageIndex,pageSize);
    }

    @RequestMapping("notice")
    public String init() {
        return "notice/notice";
    }

    @RequestMapping("add")
    public String add() {
        return "notice/noticeAdd";
    }

    @RequestMapping("save")
    @ResponseBody
    public ControllerStatusVO save(Notice notice){
        ControllerStatusVO statusVO = null;
        try {
            noticeService.save(notice);
        } catch (RuntimeException e) {
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.FRIEND_SAVE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.FRIEND_SAVE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("update")
    @ResponseBody
    public ControllerStatusVO update(Notice notice){
        ControllerStatusVO statusVO = null;
        try {
            noticeService.update(notice);
        } catch (RuntimeException e) {
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.FRIEND_UPDATE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.FRIEND_UPDATE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("delete/{nid}")
    @ResponseBody
    public ControllerStatusVO delete( @PathVariable("nid") Long id){
        ControllerStatusVO statusVO = null;
        try {
            noticeService.removeById(id);
        } catch (RuntimeException e) {
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.FRIEND_DELETE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.FRIEND_DELETE_SUCCESS);
        return statusVO;
    }


    @RequestMapping("findNotice/{nid}")
    @ResponseBody
    public Friend findNotice(@PathVariable("nid") Long fid){
        return  (Friend) noticeService.getById(fid);
    }


}
