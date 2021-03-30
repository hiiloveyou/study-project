package com.chenyi.study.rpc;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author chenyi65536@163.com
 * @date 2021/3/30-19:46
 * @description
 */
@Documented
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Import(RpcRestConfiguration.class)
public @interface EnableStudyRpcRest {
}
