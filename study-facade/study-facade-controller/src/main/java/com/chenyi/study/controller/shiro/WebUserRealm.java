package com.chenyi.study.controller.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author chenyi
 * @date 2020/11/12
 */
public class WebUserRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        final SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        final HashSet<String> roles = new HashSet<>();
        roles.add("admin");
        roles.add("normal");
        simpleAuthorizationInfo.setRoles(roles);
        final HashSet<String> permissions = new HashSet<>();
        permissions.add("USER:LIST");
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        final String username = (String) token.getPrincipal();
        final String password = new String((char[]) token.getCredentials());

        if (!Objects.equals(username, "chenyi1")) {
            throw new UnknownAccountException();
        }

        if (!Objects.equals(password, "1234")) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
