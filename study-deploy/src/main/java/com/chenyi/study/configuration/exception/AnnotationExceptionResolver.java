package com.chenyi.study.configuration.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 提供注解的异常处理
 *
 * @see SimpleExceptionResolver 通用异常
 */
@RestControllerAdvice
public class AnnotationExceptionResolver {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionResolver(HttpServletRequest request, HttpServletResponse response,
                                          Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/base/error");
        mv.addObject("status", response.getStatus());
        mv.addObject("url", request.getRequestURL());
        mv.addObject("exception", ex.getMessage());
        return mv;
    }
}
