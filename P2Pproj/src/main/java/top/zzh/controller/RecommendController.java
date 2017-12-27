package top.zzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.User;
import top.zzh.common.CheckCodeUtils;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.RecommendService;
import top.zzh.vo.ControllerStatusVO;
import top.zzh.vo.RecommendVO;

/**
 * Created by 谢学培 on 2017/12/21.
 */
@Controller
@RequestMapping("/recommend")
public class RecommendController{
    @Autowired
    private RecommendService recommendService;
    @RequestMapping("page")
    public String page(){
        return "recommend/recommend";
    }
    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int pageIndex,int pageSize,RecommendVO recommend) {
        return recommendService.listPagerCriteria(pageIndex, pageSize, recommend);
    }
    @RequestMapping("remove")
    @ResponseBody
    public ControllerStatusVO update(long id) {
        ControllerStatusVO statusVO = null;
        try {
            recommendService.remove(id);
        } catch (RuntimeException e) {
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_DELETE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_DELETE_SUCCESS);
        return statusVO;
    }
    //邀请码生成的controller
    public String save(User user){
        String tzmCode= CheckCodeUtils.tzmCode();
        boolean tzmisExit = true;
        while (tzmisExit) {
            //不存在：0  存在：1
            int isExit = recommendService.countTzm(tzmCode);
            if (isExit == 1) {
                tzmCode =CheckCodeUtils.tzmCode();
            } else if (isExit == 0) {
                tzmisExit = false;
                user.setTzm(tzmCode);
            }
        }
        return "null";
    }

}
