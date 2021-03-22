package com.chenyi.study.configuration.exception;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 提供简单的异常处理，需要时打开 @Component 注解
 *
 * @see AnnotationExceptionResolver 注解的异常
 */
@Component
public class SimpleExceptionResolver extends SimpleMappingExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/base/error");
        mv.addObject("status", response.getStatus());
        mv.addObject("url", request.getRequestURL());
        mv.addObject("exception", ex.getMessage());
        return mv;
    }

}
