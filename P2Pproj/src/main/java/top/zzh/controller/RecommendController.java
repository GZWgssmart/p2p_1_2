package top.zzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
public class RecommendController {
    @Autowired
    private RecommendService recommendService;

    @RequestMapping("page")
    public String page() {
        return "recommend/recommend";
    }

    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int pageIndex, int pageSize, RecommendVO recommend) {
        return recommendService.listPagerCriteria(pageIndex, pageSize, recommend);
    }

    @RequestMapping("remove")
    @ResponseBody
    public ControllerStatusVO remove(long id) {
        ControllerStatusVO statusVO = null;
        try {
            recommendService.remove(id);
        } catch (RuntimeException e) {
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_DELETE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_DELETE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("/delMany")
    @ResponseBody
    public ControllerStatusVO delEduList(Long[] ids) {
        ControllerStatusVO statusVO = null;
        try {
            for (Long id : ids) {
                recommendService.remove(id);
            }
        } catch (RuntimeException e) {
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_DELETE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_DELETE_SUCCESS);
        return statusVO;
    }
}
