package com.chenyi.study.shiro;

import org.apache.shiro.spring.config.ShiroConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author chenyi65536@163.com
 * @date 2021/3/30-19:18
 * @description start shiro configuration
 */
@Documented
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Import(ShiroConfiguration.class)
public @interface EnableStudyShiro {
}
