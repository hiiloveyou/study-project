package com.chenyi.study.toolkit.studythread.studythreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyi
 * @date 2021/3/16
 */
public class StudyCachedThreadPool {

    public static void main(String[] args) {

        //SynchronousQueue 不存储任何元素，只是作为通信的管道使用
        // ，如果超过最大线程数，将拒绝执行，然后跑错
        //final ExecutorService executorService = Executors.newCachedThreadPool();


        //相当于队列已满了
        final ExecutorService executorService = new ThreadPoolExecutor(0, 120,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());


        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello");
            });
        }
    }
}
