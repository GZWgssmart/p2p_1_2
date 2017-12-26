package top.zzh.common;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.zzh.bean.User;
import top.zzh.service.RoleService;
import top.zzh.service.UserService;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27 0027.
 */
@Component
public class ShiroRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


     /*
    * @param authenticationToken 包含用户名及密码的令牌对象，是由shiro传递过来的参数
    * @return
    * @throws AuthenticationException
    * */

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=(String)authenticationToken.getPrincipal();
        String password=String.valueOf((char[])authenticationToken.getCredentials());
        User user=userService.getByNamePwd(username, EncryptUtils.md5(password));
        List<String> stringList= roleService.listRoles(username);
        if(user!=null && user.getState()==1 && stringList.size()!=0){
            return new SimpleAuthenticationInfo(authenticationToken.getPrincipal(),authenticationToken.getCredentials(),"myReam");
        }
        return null;
    }
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }
}
