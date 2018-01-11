package top.zzh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.HUser;
import top.zzh.bean.Role;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.HuserRoleService;
import top.zzh.vo.ControllerStatusVO;


import java.util.List;

/**
 * Created by XIE Shanlin on 2018.01.09.
 */

@Controller
@RequestMapping("hUserRole")
public class HuserRoleController {

    @Autowired
    private HuserRoleService huserRoleService;

    @RequestMapping("hUserRolePage")
    public String hUserRolePage(Model model){
        model.addAttribute("hUserList",huserRoleService.hUserList());
        return "authorityManagement/hUserRole";
    }

    @RequestMapping("hRoleList")
    @ResponseBody
    public List<Role> hRoleList(){
        return huserRoleService.hRoleList();
    }

    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public ControllerStatusVO saveOrUpdate(String hHuserId, String roleList,String flag){
        huserRoleService.save(hHuserId,roleList);
        if("save".equals(flag)){
            return ControllerStatusVO.status(ControllerStatusEnum.HUSER_ROLE_SAVE_SUCCESS);
        }else {
            return ControllerStatusVO.status(ControllerStatusEnum.HUSER_ROLE_MODIFY_SUCCESS);
        }
    }

    //查询已经分配角色的用户
    @RequestMapping("hasRoleHuser")
    @ResponseBody
    public Pager hasRoleHuserList(int pageIndex, int pageSize){
        return huserRoleService.listPager(pageIndex,pageSize);
    }

    //通过Id查询该用户的所有角色
    @RequestMapping("hRoleByHuserId")
    @ResponseBody
    List<Role> hRoleByHuserIdList(String hUserId){
        return huserRoleService.hRoleByHuserIdList(Integer.parseInt(hUserId));
    }
}
