package com.chenyi.study.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionValidationScheduler;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.session.mgt.quartz.QuartzSessionValidationScheduler;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chenyi
 * @date 2020/11/14
 */
@Configuration
public class ShiroConfiguration {

//    @Bean
//    public RetryLimitHashedCredentialsMatcher credentialsMatcher(CacheManager cacheManager) {
//        final RetryLimitHashedCredentialsMatcher credentialsMatcher = new RetryLimitHashedCredentialsMatcher(cacheManager);
//        credentialsMatcher.setHashAlgorithmName("md5");
//        credentialsMatcher.setHashIterations(2);
//        return credentialsMatcher;
//    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
        return hashedCredentialsMatcher;
    }

    @Bean
    public WebUserRealm webUserRealm(HashedCredentialsMatcher hashedCredentialsMatcher) {
        final WebUserRealm webUserRealm = new WebUserRealm();
        webUserRealm.setCachingEnabled(false);
        webUserRealm.setAuthenticationCachingEnabled(false);
        webUserRealm.setAuthenticationCacheName("authenticationCache");
        webUserRealm.setAuthorizationCachingEnabled(false);
        webUserRealm.setAuthorizationCacheName("authorizationCache");
        webUserRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return webUserRealm;
    }

//    @Bean
//    public CacheManager cacheManager() {
//        final EhCacheManager ehCacheManager = new EhCacheManager();
//        ehCacheManager.setCacheManagerConfigFile("classpath:shiro-ehcache.xml");
//        return ehCacheManager;
//    }

    /**
     * 会话ID生成器
     *
     * @return
     */
    @Bean
    public SessionIdGenerator sessionIdGenerator() {
        return new JavaUuidSessionIdGenerator();
    }

    /**
     * 会话DAO
     *
     * @param sessionIdGenerator
     * @return
     */
//    @Bean
//    public SessionDAO sessionDAO(SessionIdGenerator sessionIdGenerator) {
//        final EnterpriseCacheSessionDAO enterpriseCacheSessionDAO = new EnterpriseCacheSessionDAO();
//        enterpriseCacheSessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
//        enterpriseCacheSessionDAO.setSessionIdGenerator(sessionIdGenerator);
//        return enterpriseCacheSessionDAO;
//    }

    /**
     * 会话验证调度器
     *
     * @return
     */
    @Bean
    public SessionValidationScheduler sessionValidationScheduler(@Lazy DefaultSessionManager defaultSessionManager) {
        final QuartzSessionValidationScheduler quartzSessionValidationScheduler = new QuartzSessionValidationScheduler();
        quartzSessionValidationScheduler.setSessionValidationInterval(1800000);
        quartzSessionValidationScheduler.setSessionManager(defaultSessionManager);
        return quartzSessionValidationScheduler;
    }

//    @Bean
//    public SimpleCookie simpleCookie() {
//        final SimpleCookie simpleCookie = new SimpleCookie();
//        simpleCookie.setName("sid");
//        simpleCookie.setHttpOnly(true);
//        simpleCookie.setMaxAge(1800000);
//        return simpleCookie;
//    }

    @Bean
    public DefaultWebSessionManager defaultWebSessionManager(SessionValidationScheduler sessionValidationScheduler
//            , SessionDAO sessionDAO
    ) {
        final DefaultWebSessionManager defaultSessionManager = new DefaultWebSessionManager();
        defaultSessionManager.setGlobalSessionTimeout(1800000);
        defaultSessionManager.setDeleteInvalidSessions(true);
        defaultSessionManager.setSessionValidationSchedulerEnabled(true);
        defaultSessionManager.setSessionValidationScheduler(sessionValidationScheduler);
//        defaultSessionManager.setSessionDAO(sessionDAO);
        defaultSessionManager.setSessionIdCookieEnabled(true);
//        defaultSessionManager.setSessionIdCookie(simpleCookie);
        return defaultSessionManager;
    }

    @Bean
    public DefaultWebSecurityManager defaultSecurityManager(WebUserRealm webUserRealm
//            , CacheManager cacheManager
//            , DefaultWebSessionManager defaultWebSessionManager
    ) {
        final DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        //设置realm
        defaultSecurityManager.setRealm(webUserRealm);
        //设置缓存器
//        defaultSecurityManager.setCacheManager(cacheManager);
        //设置会话管理器
//        defaultSecurityManager.setSessionManager(defaultWebSessionManager);
        return defaultSecurityManager;
    }

    /**
     * 相当于调用SecurityUtils.setSecurityManager(securityManager)
     *
     * @param defaultSecurityManager
     * @return
     */
    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean(DefaultSecurityManager defaultSecurityManager) {
        final MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        methodInvokingFactoryBean.setArguments(defaultSecurityManager);
        return methodInvokingFactoryBean;
    }

    /**
     * Shiro生命周期处理器
     * LifecycleBeanPostProcessor用于
     * 在实现了Initializable接口的Shiro bean初始化时调用Initializable接口回调，
     * 在实现了Destroyable接口的Shiro bean销毁时调用 Destroyable接口回调
     * 如UserRealm就实现了Initializable，而DefaultSecurityManager实现了Destroyable
     *
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        final ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //DefaultFilter枚举定义默认Filter
        final Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //anon默认过滤器
        filterChainDefinitionMap.put("/favicon.ico", DefaultFilter.anon.name());
        filterChainDefinitionMap.put("/css/**", DefaultFilter.anon.name());
        filterChainDefinitionMap.put("/images/**", DefaultFilter.anon.name());
        filterChainDefinitionMap.put("/js/**", DefaultFilter.anon.name());
        filterChainDefinitionMap.put("/base/**", DefaultFilter.anon.name());
        filterChainDefinitionMap.put("/test/**", DefaultFilter.anon.name());
//        filterChainDefinitionMap.put("/login/**", DefaultFilter.anon.name());
        //其他过滤器
//        filterChainDefinitionMap.put("/login/logout", DefaultFilter.logout.name());
//        filterChainDefinitionMap.put("/**", DefaultFilter.authc.name());
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //配置拦截器，自定义拦截器名称需要和上面的拦截器路径配置的拦截器名称一致
        final Map<String, Filter> filterMap = new HashMap<>();
//        filterMap.put("form", formAuthenticationFilter());
//        filterMap.put("user", userFilter());

        shiroFilterFactoryBean.setFilters(filterMap);

        shiroFilterFactoryBean.setLoginUrl("/login/loginUser");
        shiroFilterFactoryBean.setSuccessUrl("/login/home");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        return shiroFilterFactoryBean;
    }

    //    @Bean
//    public UserFilter userFilter() {
//        return new UserFilter();
//    }
//
    @Bean
    public FormAuthenticationFilter formAuthenticationFilter() {
        final FormAuthenticationFilter formAuthenticationFilter = new WebUserFormAuthenticationFilter();
        formAuthenticationFilter.setUsernameParam("username");
        formAuthenticationFilter.setPasswordParam("password");
        formAuthenticationFilter.setLoginUrl("/login/loginUser");
        return formAuthenticationFilter;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor advisor(DefaultWebSecurityManager defaultWebSecurityManager) {
        final AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(defaultWebSecurityManager);
        return advisor;
    }

    @DependsOn("lifecycleBeanPostProcessor")
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

}
