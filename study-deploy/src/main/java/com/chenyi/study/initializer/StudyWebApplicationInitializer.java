package com.chenyi.study.initializer;

import com.chenyi.study.StudyUtilApplication;
import com.chenyi.study.configuration.DataSourceConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * WebMvcConfigurer的实现子类
 */
@Configuration
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
        return new Class<?>[]{DataSourceConfiguration.class};
    }
}
