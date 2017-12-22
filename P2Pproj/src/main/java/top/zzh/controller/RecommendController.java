package top.zzh.controller;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.Recommend;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.RecommendService;
import top.zzh.vo.ControllerStatusVO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by 谢学培 on 2017/12/21.
 */
@Controller
@RequestMapping("recommend")
public class RecommendController {
    @Autowired
    private RecommendService recommendService;
    @RequestMapping("list")
    public String list(){
        return "recommend/recommend";
    }
    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pagerCriteria(int page, int rows, Recommend recommend) {
        return recommendService.listPagerCriteria(page, rows, recommend);
    }
    @RequestMapping("remove")
    @ResponseBody
    public ControllerStatusVO update(Recommend recommend) {
        ControllerStatusVO statusVO = null;
        try {
            recommendService.remove(recommend);
        } catch (RuntimeException e) {
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_UPDATE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_UPDATE_SUCCESS);
        return statusVO;
    }
    @RequestMapping("export")
    public void exportExcel(HttpServletResponse response, Recommend recommend) {
        Workbook workbook = recommendService.export(recommend);
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment; filename=recommend.xlsx");
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        try {
            OutputStream out = response.getOutputStream();
            workbook.write(out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
