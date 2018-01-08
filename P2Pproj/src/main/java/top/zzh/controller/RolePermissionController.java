package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.RolePermissionService;
import top.zzh.vo.ControllerStatusVO;
import top.zzh.vo.Select2;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XIE Shanlin on 2018.01.04.
 */
@Controller
@RequestMapping("/rolePermission")
public class RolePermissionController {

    private Logger logger = LoggerFactory.getLogger(RolePermissionController.class);

    @Autowired
    private RolePermissionService rolePermissionService;


    @RequestMapping("rolePermissionPage")
    public String rolePermissionPage(String roleId, Model model,HttpSession session) {
        if(roleId != null){
            session.setAttribute("roleId",roleId);
            System.out.println("-------------------roleId"+roleId);
        }
        model.addAttribute("permissionList",rolePermissionService.listPermission());
        return "authorityManagement/rolePermission";
    }

    @RequestMapping("role")
    @ResponseBody
    public List<Select2> role(HttpSession session){
        List<Select2> list = rolePermissionService.listRole();
        session.removeAttribute("roleId");
        return list;
    }

    @RequestMapping("saveOrUpdateRP")
    @ResponseBody
    public ControllerStatusVO saveOrUpdateRP(String roleId,String permissionIds){
        try {
            rolePermissionService.deleteRolePermission(roleId);
            rolePermissionService.saveRolePermission(roleId,permissionIds);
            return ControllerStatusVO.status(ControllerStatusEnum.ROLE_PERMISSION_SAVE_SUCCESS);
        }catch (Exception e){
            logger.error("角色分配权限发生错误"+e.getMessage());
            return ControllerStatusVO.status(ControllerStatusEnum.ROLE_PERMISSION_SAVE_FAIL);
        }
    }

}
