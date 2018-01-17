package top.zzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.zzh.bean.Friend;
import top.zzh.bean.Home;
import top.zzh.bean.Notice;
import top.zzh.bean.User;
import top.zzh.common.Pager;
import top.zzh.service.BorrowApplyService;
import top.zzh.service.FriendService;
import top.zzh.service.NoticeService;
import top.zzh.service.*;
import top.zzh.vo.BorrowDetailVO;
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
    private UserService userService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private BorrowApplyService borrowApplyService;

    @Autowired
    private HomeService homeService;

    @Autowired
    private MediaService mediaService;

    @Autowired
    private DynamicService dynamicService;

    @Autowired
    private TzbService tzbService;

    @RequestMapping("")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        //首页显示投资列表
        List<BorrowDetailVO> borrow1 = (List)borrowApplyService.souye1();
        List<BorrowDetailVO> borrow2 = (List)borrowApplyService.souye2();
        List<BorrowDetailVO> borrow3 = (List)borrowApplyService.souye3();
        List<BorrowDetailVO> borrow4 = (List)borrowApplyService.souye4();
        //首页统计用户人数
        Long user = (Long)userService.count();
        //首页统计贷款人数
        Long tz = (Long)tzbService.count();
        List<Friend> friendList = new ArrayList<Friend>();
        friendList = friendService.listFriend();
        List<Object> homeList = new ArrayList<>();
        homeList = homeService.listAll();
        List<Object> noticeList = new ArrayList<>();
        List<Object> mediaList = new ArrayList<>();
        List<Object> dynamicList = new ArrayList<>();
        int pageIndex = 0;
        int pageSize = 5;
        //首页显示网站公告信息
        noticeList = noticeService.listNotice(pageIndex,pageSize);
        mediaList = mediaService.listMedia(pageIndex,pageSize);
        dynamicList = dynamicService.listDynamic(pageIndex,pageSize);
        modelAndView.addObject("user",user);
        modelAndView.addObject("tz",tz);
        modelAndView.addObject("noticeList",noticeList);
        modelAndView.addObject("friendList",friendList);
        modelAndView.addObject("homeList",homeList);
        modelAndView.addObject("mediaList", mediaList);
        modelAndView.addObject("dynamicList", dynamicList);
        modelAndView.addObject("borrow1",borrow1);
        modelAndView.addObject("borrow2",borrow2);
        modelAndView.addObject("borrow3",borrow3);
        modelAndView.addObject("borrow4",borrow4);
        modelAndView.addObject("noticeList",noticeList);
        modelAndView.addObject("friendList",friendList);
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
