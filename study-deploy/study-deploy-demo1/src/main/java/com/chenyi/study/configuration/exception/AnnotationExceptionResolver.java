package com.chenyi.study.configuration.exception;

/**
 * 提供注解的异常处理
 *
 * @see SimpleExceptionResolver 通用异常
 */
//@RestControllerAdvice
//public class AnnotationExceptionResolver {
//
//    @ExceptionHandler(Exception.class)
//    public ModelAndView exceptionResolver(HttpServletRequest request, HttpServletResponse response,
//                                          Object handler, Exception ex) {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("/base/error");
//        mv.addObject("status", response.getStatus());
//        mv.addObject("url", request.getRequestURL());
//        mv.addObject("exception", ex.getMessage());
//        return mv;
//    }
//}
