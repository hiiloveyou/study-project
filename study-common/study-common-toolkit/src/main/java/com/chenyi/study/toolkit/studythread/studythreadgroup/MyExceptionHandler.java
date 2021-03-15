package com.chenyi.study.toolkit.studythread.studythreadgroup;

/**
 * @author chenyi
 * @date 2021/3/14
 */
public class MyExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        System.out.println("t.getName() = " + t.getName() + "发生了异常");
        System.out.println("e = " + e);
    }
}
