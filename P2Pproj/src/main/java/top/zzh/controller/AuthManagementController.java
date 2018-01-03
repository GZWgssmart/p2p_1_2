package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.Jur;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.AuthManagementService;
import top.zzh.vo.ControllerStatusVO;

/**
 * Created by XIE Shanlin on 2017.12.27.
 */
@Controller
@RequestMapping("/authManage")
public class AuthManagementController {

    private Logger logger = LoggerFactory.getLogger(AuthManagementController.class);

    @Autowired
    private AuthManagementService authManagementService;

    @RequestMapping("permissionPage")
    public String permissionPage() {
        return "authorityManagement/permission";
    }

    @RequestMapping("permissionCriteriaQuery")
    @ResponseBody
    public Pager permissionByCriteria(int pageIndex, int pageSize, Jur jur) {
        logger.info("按条件查询权限");
        return authManagementService.permissionListPagerCriteria(pageIndex,pageSize,jur);
    }

    @RequestMapping("addPermission")
    @ResponseBody
    public ControllerStatusVO addPermission(Jur jur){
        logger.info("超级管理员新增权限");
        try {
            authManagementService.addPermission(jur);
            return ControllerStatusVO.status(ControllerStatusEnum.PERMISSION_ADD_SUCCESS);
        }catch (Exception e){
            logger.error("超级管理员新增权限失败"+e.getMessage());
            return ControllerStatusVO.status(ControllerStatusEnum.PERMISSION_ADD_FAIL);
        }
    }

    @RequestMapping("updatePermission")
    @ResponseBody
    public ControllerStatusVO updatePermission(Jur jur) {
        logger.info("超级管理员修改权限");
        try {
            authManagementService.updatePermission(jur);
            return ControllerStatusVO.status(ControllerStatusEnum.PERMISSION_UPDATE_SUCCESS);
        }catch (Exception e){
            logger.error("超级管理员修改权限失败"+e.getMessage());
            return ControllerStatusVO.status(ControllerStatusEnum.PERMISSION_UPDATE_FAIL);
        }
    }


}
