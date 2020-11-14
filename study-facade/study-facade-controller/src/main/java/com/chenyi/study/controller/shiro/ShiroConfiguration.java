package com.chenyi.study.controller.shiro;

import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenyi
 * @date 2020/11/14
 */
@Configuration
public class ShiroConfiguration {

    @Bean
    public WebUserRealm webUserRealm() {
        return new WebUserRealm();
    }

    @Bean
    public DefaultSecurityManager defaultSecurityManager(WebUserRealm webUserRealm) {
        final DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //设置realm
        defaultSecurityManager.setRealm(webUserRealm);
        //设置authenticator
        final ModularRealmAuthenticator modularRealmAuthenticator = new ModularRealmAuthenticator();
        modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        defaultSecurityManager.setAuthenticator(modularRealmAuthenticator);

        //设置authorizer
        final ModularRealmAuthorizer modularRealmAuthorizer = new ModularRealmAuthorizer();
        modularRealmAuthorizer.setPermissionResolver(new WildcardPermissionResolver());
        defaultSecurityManager.setAuthorizer(modularRealmAuthorizer);

        //用户登陆
//        SecurityUtils.setSecurityManager(defaultSecurityManager);
//        final Subject subject = SecurityUtils.getSubject();
//        final UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken();
//        usernamePasswordToken.setUsername("");
//        usernamePasswordToken.setPassword("".toCharArray());
//        subject.login(usernamePasswordToken);

        return defaultSecurityManager;
    }


}
