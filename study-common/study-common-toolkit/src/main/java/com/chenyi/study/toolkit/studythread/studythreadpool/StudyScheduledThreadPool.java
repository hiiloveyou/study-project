package com.chenyi.study.toolkit.studythread.studythreadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyi
 * @date 2021/3/16
 */
public class StudyScheduledThreadPool {

    public static void main(String[] args) {

        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        //启动后延迟 delay 后执行
//        scheduledExecutorService.schedule(() -> System.out.println("hello"), 5, TimeUnit.SECONDS);


//        启动延迟 initialDelay 后，每隔 period 后再执行，不包含任务任务执行的时间
//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//                    System.out.println(System.currentTimeMillis());
//                    System.out.println("hello");
//
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace);
//                    }
//                },
//                5, 3, TimeUnit.SECONDS);


        //每隔多长时间执行，执行间隔时间为 delay+任务的时间
        scheduledExecutorService.scheduleWithFixedDelay(() -> {

                    System.out.println(System.currentTimeMillis());
                    System.out.println("hello");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                5, 3, TimeUnit.SECONDS);
    }
}
