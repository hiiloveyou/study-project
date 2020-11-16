package com.chenyi.study.controller.shiroconfiguration.shirofilter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author chenyi
 * @date 2020/11/14
 */
@Slf4j
public class WebUserFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        // TODO: 2020/11/16 自定义拦截处理
        if (isLoginRequest(request, response) && isLoginSubmission(request, response)) {
            log.info("<<<<<login ing>>>>>");
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        // TODO: 2020/11/16 登陆成功跳转
        log.info("<<<<<login success>>>>>");
        return super.onLoginSuccess(token, subject, request, response);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        // TODO: 2020/11/16 登陆失败处理
        log.info("<<<<<login error>>>>>");
        return true;
    }
}
