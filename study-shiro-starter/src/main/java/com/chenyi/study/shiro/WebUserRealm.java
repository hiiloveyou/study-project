package com.chenyi.study.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Set;

/**
 * @author chenyi
 * @date 2020/11/12
 */
public class WebUserRealm extends AuthorizingRealm {
//    @Autowired
//    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        final UserVO uservo = (UserVO) principals.getPrimaryPrincipal();

        final SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取用户角色
        final Set<String> roles = null;
//                userService.findRolesByLoginName(uservo.getLoginName());
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(null
//                userService.findPermissionsByLoginName(uservo.getLoginName())
        );
        //获取用户权限
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        final String loginName = (String) token.getPrincipal();

//        final User user = userService.findByLoginName(loginName);
//        final UserVO uservo = userService.findUserVOByLoginName(loginName);
//
//        if (null == user) {
//            throw new UnknownAccountException(loginName);
//        }
//
//        if (Objects.equals(ConstantUtil.STATUS_DISABLE, user.getStatus())) {
//            throw new LockedAccountException(loginName);
//        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        //credentialSalt = loginName+salt
//        return new SimpleAuthenticationInfo(uservo, user.getPassword(),
//                ByteSource.Util.bytes(user.getCredentialSalt()), getName());

        return null;
    }


}
