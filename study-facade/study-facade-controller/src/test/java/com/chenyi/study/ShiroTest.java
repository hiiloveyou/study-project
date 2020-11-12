package com.chenyi.study;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author chenyi
 * @date 2020/11/11
 */
public class ShiroTest {
    private static Subject subject;

    @BeforeAll
    static void beforeAll() {
        final Factory<SecurityManager> factory = new IniSecurityManagerFactory(
                "classpath:shiro-authenticator-all-success.ini");
        final SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        subject = SecurityUtils.getSubject();
        final UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken();
        usernamePasswordToken.setUsername("chenyi1");
        usernamePasswordToken.setPassword("1234".toCharArray());

        try {
            subject.login(usernamePasswordToken);
            System.out.println("登陆成功");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        assertThat(subject.isAuthenticated()).isTrue();
    }

    @Test
    void testSubject() {
        subject.checkPermission("USER:LIST");
        assertThat(subject.hasRole("admin")).isTrue();

    }

    @Test
    public void testAllSuccessfulStrategyWithSuccess() {
        //得到一个身份集合，其包含了Realm验证成功的身份信息
        PrincipalCollection principalCollection = subject.getPrincipals();
        assertThat(principalCollection.asList().size()).isEqualTo(1);
    }


    @AfterAll
    static void afterAll() {
        subject.logout();
        System.out.println("用户退出");
    }

}
