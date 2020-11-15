//package com.chenyi.study.configuration.webservlet;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.ViewResolver;
//import org.thymeleaf.spring5.ISpringTemplateEngine;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//import org.thymeleaf.templatemode.TemplateMode;
//import org.thymeleaf.templateresolver.ITemplateResolver;
//
//@Configuration
//public class ThymeleafConfiguration {
//    /**
//     * 模版解析器
//     *
//     * @return
//     */
//    @Bean
//    public ITemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        //此处需要配置类路径
//        templateResolver.setPrefix("classpath:/templates/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode(TemplateMode.HTML);
//        templateResolver.setCacheable(false);
//        templateResolver.setCharacterEncoding("utf-8");
//        return templateResolver;
//    }
//
//    /**
//     * 模版引擎
//     *
//     * @param templateResolver
//     * @return
//     */
//    @Bean
//    public ISpringTemplateEngine springTemplateEngine(ITemplateResolver templateResolver) {
//        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
//        springTemplateEngine.setTemplateResolver(templateResolver);
//        return springTemplateEngine;
//    }
//
//    /**
//     * 视图解析器
//     *
//     * @param springTemplateEngine
//     * @return
//     */
//    @Bean
//    public ViewResolver viewResolver(ISpringTemplateEngine springTemplateEngine) {
//        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
//        thymeleafViewResolver.setTemplateEngine(springTemplateEngine);
//        return thymeleafViewResolver;
//    }
//
//}
