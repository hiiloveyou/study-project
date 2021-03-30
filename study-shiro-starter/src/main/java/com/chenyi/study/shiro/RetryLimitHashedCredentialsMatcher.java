package com.chenyi.study.shiro;


import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenyi
 * @date 2020/11/14
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
    private final Cache<String, AtomicInteger> passwordRetryCache;
//    @Autowired
//    private UserService userService;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String loginName = (String) token.getPrincipal();
        //retry count + 1
        AtomicInteger retryCount = passwordRetryCache.get(loginName);
        if (retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(loginName, retryCount);
        }
        if (retryCount.incrementAndGet() > 5) {
            //if retry count > 5 throw
            throw new ExcessiveAttemptsException();
        }

        final String password = new String((char[]) token.getCredentials());

//        final User user = userService.findByLoginName(loginName);
//        //校验密码
//        if (!Objects.equals(user.getPassword(), password)) {
//            throw new IncorrectCredentialsException("账号或密码错误，请重试");
//        }


        boolean matches = super.doCredentialsMatch(token, info);
//        if (matches) {
//            //clear retry count
//            passwordRetryCache.remove(loginName);
//        }
        return true;
    }
}
