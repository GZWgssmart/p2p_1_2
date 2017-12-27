package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzh.bean.HUser;
import top.zzh.common.EncryptUtils;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.HuserService;
import top.zzh.vo.ControllerStatusVO;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Huser")
public class HuserController {

    @Autowired
    private HuserService huserService;


    private Logger logger = LoggerFactory.getLogger(HuserController.class);

    @RequestMapping("logout")
    public String logout(HttpSession session){
        logger.info("安全退出");
        session.invalidate();
        return "manager/login";
    }
    //后台用户中心页面
    @RequestMapping("page")
    @ResponseBody
    public ControllerStatusVO page(String pwd, String phone){
        ControllerStatusVO statusVO = null;
        HUser hUser=huserService.getByNamePwd(phone, EncryptUtils.md5(pwd));
        if(hUser!=null && hUser.getState()==1){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_SUCCESS);
        }else{
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_PHONEFAIL);
        }
        return  statusVO;
    }

    @RequestMapping("checkPhone")
    @ResponseBody
    public ControllerStatusVO checkPhone(String phone){
        ControllerStatusVO statusVO=null;
        HUser user=huserService.getByPhone(phone);
        if(user!=null){
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_ERROR_ALREADYEXIST);
        }

        return  statusVO;
    }

    @PostMapping("registerSave")
    @ResponseBody
    public ControllerStatusVO  registerSave(HUser hUser){
        ControllerStatusVO statusVO=null;
        String pwd=EncryptUtils.md5(hUser.getHpwd());
        hUser.setHpwd(pwd);
        huserService.register(hUser);
        statusVO=ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("index")
    private String index(){
        return "manager/index";
    }
       //后台用户登录页面
    @RequestMapping("login")
    public String login(){
        return "manager/login";
    }

    //后台用户注册页面
    @RequestMapping("register")
    public String register(){
        return "manager/register";
    }

    @RequestMapping("forgerView")
    private String forgerView(){
        return "manager/forgetPwd";
    }

    @RequestMapping("husercheckPhone")
    @ResponseBody
    public ControllerStatusVO husercheckPhone(String phone){
        ControllerStatusVO statusVO=null;
        HUser user=huserService.getByPhone(phone);
        if(user==null){
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_ERROR_EXIST);
        }

        return  statusVO;
    }

    @RequestMapping("huserLogin")
    @ResponseBody
    public ControllerStatusVO huserLogin(String phone){
        ControllerStatusVO statusVO=null;
        HUser user=huserService.getByPhone(phone);
        if(user==null){
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_ERROR_EXIST_POWER);
        }

        if(user!=null && user.getState()==1){
            statusVO=ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_SUCCESS);
        }

        return  statusVO;
    }


}
