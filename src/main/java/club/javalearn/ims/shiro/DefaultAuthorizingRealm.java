package club.javalearn.ims.shiro;

import club.javalearn.ims.entity.Permission;
import club.javalearn.ims.entity.Role;
import club.javalearn.ims.entity.User;
import club.javalearn.ims.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/11/20
 * Time: 下午9:45
 * Description: No Description
 */
public class DefaultAuthorizingRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;


    /**
     * 认证.登录
     *
     * @param token 用户信息
     * @return AuthenticationInfo
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户输入的token
        UsernamePasswordToken uToken = (UsernamePasswordToken) token;
        String username = uToken.getUsername();
        User user = userService.findUserByName(username);
        //放入shiro.调用CredentialsMatcher检验密码
        return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), this.getClass().getName());
    }

    /**
     * 授权
     *
     * @param principal 用户登录信息
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        //获取session中的用户
        User user = (User) principal.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissions = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        if (roles.size() > 0) {
            for (Role role : roles) {
                Set<Permission> permissionList = role.getPermissions();
                if (CollectionUtils.isNotEmpty(permissionList)) {
                    for (Permission permission : permissionList) {
                        permissions.add(permission.getUrl());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //将权限放入shiro中.
        info.addStringPermissions(permissions);
        return info;
    }


    @Override
    public String getName() {
        return "DefaultAuthorizingRealm";
    }
}
