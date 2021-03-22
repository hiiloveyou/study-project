package com.chenyi.study.configuration.initializer;

import com.chenyi.study.StudyUtilApplication;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * WebMvcConfigurer的实现子类
 */
//@Component
public class StudyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{StudyUtilApplication.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
//        return new Class<?>[]{DataSourceConfiguration.class};
    }
}
