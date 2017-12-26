package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.zzh.common.PathUtil;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.UploadExcelService;
import top.zzh.vo.ControllerStatusVO;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by XIE Shanlin on 2017.12.25.<br/>
 * 上传Excel文件
 */
@Controller
@RequestMapping("/uploadExcel")
public class UploadExcel {

    private Logger logger = LoggerFactory.getLogger(UploadExcel.class);

    @Autowired
    private UploadExcelService uploadExcelService;

    @RequestMapping("upPage")
    public String upPage(){
        return "excel/uploadExcel";
    }

    //上传excel文件并导入到数据库中
    @PostMapping("up_saveDb")
    @ResponseBody
    public ControllerStatusVO uploadExcelAndIntoDB(MultipartFile file, HttpServletRequest request){
        return uploadExcelService.uploadExcelAndIntoDB(file,request);
    }





}
