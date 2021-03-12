package com.chenyi.study.toolkit.studyreflect;

import java.lang.reflect.Proxy;

/**
 * @author BG344144
 * @date 2021/3/12-13:49
 * @description
 */
public class StudyReflectProxy {

    public static void main(String[] args) {
        final StudyReflect studyReflect = (StudyReflect) Proxy.newProxyInstance(StudyReflect.class.getClassLoader(),
                new Class[]{StudyReflect.class}, (proxy, method, args1) -> {
                    System.out.println(method);
                    System.out.println("args1 = " + args1[0]);
                    return null;
                });
        studyReflect.printMessage("hello");
    }

}
