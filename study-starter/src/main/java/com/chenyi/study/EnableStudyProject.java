package com.chenyi.study;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author chenyi65536@163.com
 * @date 2021/3/22-20:56
 * @description
 */
@Documented
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Import(StudyCoreConfiguration.class)
public @interface EnableStudyProject {
}
