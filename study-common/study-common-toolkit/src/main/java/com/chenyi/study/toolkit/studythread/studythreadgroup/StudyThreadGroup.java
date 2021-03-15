package com.chenyi.study.toolkit.studythread.studythreadgroup;

/**
 * @author chenyi
 * @date 2021/3/14
 */
public class StudyThreadGroup extends Thread {

    public StudyThreadGroup(String name) {
        super(name);
    }

    public static void main(String[] args) {

        final ThreadGroup threadGroup = new ThreadGroup("新线程组");
        threadGroup.setMaxPriority(Thread.MIN_PRIORITY);


        final Thread thread = new Thread(threadGroup, "新线程");

        System.out.println("main threadGroup = " + Thread.currentThread().getThreadGroup());
        System.out.println("thread threadGroup = " + thread.getThreadGroup());
        System.out.println("thread priority = " + thread.getPriority());

        thread.start();

        System.out.println("threadGroup.activeCount() = " + threadGroup.activeCount());
        System.out.println("threadGroup.activeGroupCount() = " + threadGroup.activeGroupCount());
        System.out.println("threadGroup.getMaxPriority() = " + threadGroup.getMaxPriority());
        System.out.println("threadGroup.isDaemon() = " + threadGroup.isDaemon());
        System.out.println("threadGroup.isDestroyed() = " + threadGroup.isDestroyed());

        //主线程设置默认异常处理
        Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler());

        int num = 5 / 0;

        //设置实例线程的异常处理
        thread.setUncaughtExceptionHandler(new MyExceptionHandler());

    }
}
