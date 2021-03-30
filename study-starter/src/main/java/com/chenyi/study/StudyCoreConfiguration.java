package com.chenyi.study;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenyi65536@163.com
 * @date 2021/3/22-20:58
 * @description
 */
@Configuration
@ConditionalOnBean(StudyProjectTrigger.class)
public class StudyCoreConfiguration {
}
