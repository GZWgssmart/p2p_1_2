package top.zzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zzh.bean.Friend;
import top.zzh.bean.Notice;
import top.zzh.common.Pager;
import top.zzh.service.FriendService;
import top.zzh.service.NoticeService;
import top.zzh.vo.NoticeVo;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 首页控制器
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private FriendService friendService;

    @Autowired
    private NoticeService noticeService;


    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping("/index")
    public String init(HttpServletRequest request){
        List<Friend> friendList = new ArrayList<Friend>();
        friendList = friendService.listFriend();
        List<Object> noticeList = new ArrayList<>();
        int pageIndex = 0;
        int pageSize = 5;
        noticeList = noticeService.listNotice(pageIndex,pageSize);

        request.setAttribute("noticeList",noticeList);
        request.setAttribute("friendList",friendList);
        return "index";
    }

}
