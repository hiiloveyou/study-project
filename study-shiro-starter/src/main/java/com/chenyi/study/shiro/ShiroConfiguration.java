//package com.chenyi.study.shiro;
//
//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.mgt.DefaultSecurityManager;
//import org.apache.shiro.session.mgt.DefaultSessionManager;
//import org.apache.shiro.session.mgt.SessionValidationScheduler;
//import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
//import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
//import org.apache.shiro.session.mgt.quartz.QuartzSessionValidationScheduler;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
//import org.apache.shiro.web.filter.mgt.DefaultFilter;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.context.annotation.Lazy;
//
//import javax.servlet.Filter;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * @author chenyi
// * @date 2020/11/14
// */
//@Configuration
//public class ShiroConfiguration {
//
////    @Bean
////    public RetryLimitHashedCredentialsMatcher credentialsMatcher(CacheManager cacheManager) {
////        final RetryLimitHashedCredentialsMatcher credentialsMatcher = new RetryLimitHashedCredentialsMatcher(cacheManager);
////        credentialsMatcher.setHashAlgorithmName("md5");
////        credentialsMatcher.setHashIterations(2);
////        return credentialsMatcher;
////    }
//
//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");//????????????:????????????MD5??????;
//        hashedCredentialsMatcher.setHashIterations(2);//???????????????????????????????????????????????? md5(md5(""));
//        return hashedCredentialsMatcher;
//    }
//
//    @Bean
//    public WebUserRealm webUserRealm(HashedCredentialsMatcher hashedCredentialsMatcher) {
//        final WebUserRealm webUserRealm = new WebUserRealm();
//        webUserRealm.setCachingEnabled(false);
//        webUserRealm.setAuthenticationCachingEnabled(false);
//        webUserRealm.setAuthenticationCacheName("authenticationCache");
//        webUserRealm.setAuthorizationCachingEnabled(false);
//        webUserRealm.setAuthorizationCacheName("authorizationCache");
//        webUserRealm.setCredentialsMatcher(hashedCredentialsMatcher);
//        return webUserRealm;
//    }
//
////    @Bean
////    public CacheManager cacheManager() {
////        final EhCacheManager ehCacheManager = new EhCacheManager();
////        ehCacheManager.setCacheManagerConfigFile("classpath:shiro-ehcache.xml");
////        return ehCacheManager;
////    }
//
//    /**
//     * ??????ID?????????
//     *
//     * @return
//     */
//    @Bean
//    public SessionIdGenerator sessionIdGenerator() {
//        return new JavaUuidSessionIdGenerator();
//    }
//
//    /**
//     * ??????DAO
//     *
//     * @param sessionIdGenerator
//     * @return
//     */
////    @Bean
////    public SessionDAO sessionDAO(SessionIdGenerator sessionIdGenerator) {
////        final EnterpriseCacheSessionDAO enterpriseCacheSessionDAO = new EnterpriseCacheSessionDAO();
////        enterpriseCacheSessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
////        enterpriseCacheSessionDAO.setSessionIdGenerator(sessionIdGenerator);
////        return enterpriseCacheSessionDAO;
////    }
//
//    /**
//     * ?????????????????????
//     *
//     * @return
//     */
//    @Bean
//    public SessionValidationScheduler sessionValidationScheduler(@Lazy DefaultSessionManager defaultSessionManager) {
//        final QuartzSessionValidationScheduler quartzSessionValidationScheduler = new QuartzSessionValidationScheduler();
//        quartzSessionValidationScheduler.setSessionValidationInterval(1800000);
//        quartzSessionValidationScheduler.setSessionManager(defaultSessionManager);
//        return quartzSessionValidationScheduler;
//    }
//
////    @Bean
////    public SimpleCookie simpleCookie() {
////        final SimpleCookie simpleCookie = new SimpleCookie();
////        simpleCookie.setName("sid");
////        simpleCookie.setHttpOnly(true);
////        simpleCookie.setMaxAge(1800000);
////        return simpleCookie;
////    }
//
//    @Bean
//    public DefaultWebSessionManager defaultWebSessionManager(SessionValidationScheduler sessionValidationScheduler
////            , SessionDAO sessionDAO
//    ) {
//        final DefaultWebSessionManager defaultSessionManager = new DefaultWebSessionManager();
//        defaultSessionManager.setGlobalSessionTimeout(1800000);
//        defaultSessionManager.setDeleteInvalidSessions(true);
//        defaultSessionManager.setSessionValidationSchedulerEnabled(true);
//        defaultSessionManager.setSessionValidationScheduler(sessionValidationScheduler);
////        defaultSessionManager.setSessionDAO(sessionDAO);
//        defaultSessionManager.setSessionIdCookieEnabled(true);
////        defaultSessionManager.setSessionIdCookie(simpleCookie);
//        return defaultSessionManager;
//    }
//
//    @Bean
//    public DefaultWebSecurityManager defaultSecurityManager(WebUserRealm webUserRealm
////            , CacheManager cacheManager
////            , DefaultWebSessionManager defaultWebSessionManager
//    ) {
//        final DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
//        //??????realm
//        defaultSecurityManager.setRealm(webUserRealm);
//        //???????????????
////        defaultSecurityManager.setCacheManager(cacheManager);
//        //?????????????????????
////        defaultSecurityManager.setSessionManager(defaultWebSessionManager);
//        return defaultSecurityManager;
//    }
//
//    /**
//     * ???????????????SecurityUtils.setSecurityManager(securityManager)
//     *
//     * @param defaultSecurityManager
//     * @return
//     */
//    @Bean
//    public MethodInvokingFactoryBean methodInvokingFactoryBean(DefaultSecurityManager defaultSecurityManager) {
//        final MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
//        methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
//        methodInvokingFactoryBean.setArguments(defaultSecurityManager);
//        return methodInvokingFactoryBean;
//    }
//
//    /**
//     * Shiro?????????????????????
//     * LifecycleBeanPostProcessor??????
//     * ????????????Initializable?????????Shiro bean??????????????????Initializable???????????????
//     * ????????????Destroyable?????????Shiro bean??????????????? Destroyable????????????
//     * ???UserRealm????????????Initializable??????DefaultSecurityManager?????????Destroyable
//     *
//     * @return
//     */
//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
//    @Bean
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
//        final ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
//        //DefaultFilter??????????????????Filter
//        final Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        //anon???????????????
//        filterChainDefinitionMap.put("/favicon.ico", DefaultFilter.anon.name());
//        filterChainDefinitionMap.put("/css/**", DefaultFilter.anon.name());
//        filterChainDefinitionMap.put("/images/**", DefaultFilter.anon.name());
//        filterChainDefinitionMap.put("/js/**", DefaultFilter.anon.name());
//        filterChainDefinitionMap.put("/base/**", DefaultFilter.anon.name());
//        filterChainDefinitionMap.put("/test/**", DefaultFilter.anon.name());
////        filterChainDefinitionMap.put("/login/**", DefaultFilter.anon.name());
//        //???????????????
////        filterChainDefinitionMap.put("/login/logout", DefaultFilter.logout.name());
////        filterChainDefinitionMap.put("/**", DefaultFilter.authc.name());
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        //?????????????????????????????????????????????????????????????????????????????????????????????????????????
//        final Map<String, Filter> filterMap = new HashMap<>();
////        filterMap.put("form", formAuthenticationFilter());
////        filterMap.put("user", userFilter());
//
//        shiroFilterFactoryBean.setFilters(filterMap);
//
//        shiroFilterFactoryBean.setLoginUrl("/login/loginUser");
//        shiroFilterFactoryBean.setSuccessUrl("/login/home");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
//        return shiroFilterFactoryBean;
//    }
//
//    //    @Bean
////    public UserFilter userFilter() {
////        return new UserFilter();
////    }
////
//    @Bean
//    public FormAuthenticationFilter formAuthenticationFilter() {
//        final FormAuthenticationFilter formAuthenticationFilter = new WebUserFormAuthenticationFilter();
//        formAuthenticationFilter.setUsernameParam("username");
//        formAuthenticationFilter.setPasswordParam("password");
//        formAuthenticationFilter.setLoginUrl("/login/loginUser");
//        return formAuthenticationFilter;
//    }
//
//    @Bean
//    public AuthorizationAttributeSourceAdvisor advisor(DefaultWebSecurityManager defaultWebSecurityManager) {
//        final AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
//        advisor.setSecurityManager(defaultWebSecurityManager);
//        return advisor;
//    }
//
//    @DependsOn("lifecycleBeanPostProcessor")
//    @Bean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
//        proxyCreator.setProxyTargetClass(true);
//        return proxyCreator;
//    }
//
//}
