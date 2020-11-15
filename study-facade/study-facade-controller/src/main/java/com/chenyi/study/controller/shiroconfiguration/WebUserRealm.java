package com.chenyi.study.controller.shiroconfiguration;

import com.chenyi.study.model.user.User;
import com.chenyi.study.service.user.UserService;
import com.chenyi.study.toolkit.baseinfo.ConstantUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.Set;

/**
 * @author chenyi
 * @date 2020/11/12
 */
public class WebUserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        final String loginName = (String) principals.getPrimaryPrincipal();

        final SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取用户角色
        final Set<String> roles = userService.findRolesByLoginName(loginName);
        simpleAuthorizationInfo.setRoles(roles);
        //获取用户权限
        final Set<String> permissions = userService.findPermissionsByLoginName(loginName);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        final String loginName = (String) token.getPrincipal();

        final User user = userService.findByLoginName(loginName);

        if (null == user) {
            throw new UnknownAccountException(loginName);
        }

        if (Objects.equals(ConstantUtil.STATUS_DISABLE, user.getStatus())) {
            throw new LockedAccountException(loginName);
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        //credentialSalt = loginName+salt
        return new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(),
                ByteSource.Util.bytes(user.getLoginName() + user.getSalt()), getName());
    }
}
