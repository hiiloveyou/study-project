package com.chenyi.study.toolkit.studythread.studythreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenyi
 * @date 2021/3/16
 */
public class StudyFixedThreadPool {

    public static void main(String[] args) {

        /**
         * 只有5个核心的线程一直在执行，其他的任务放到无解队列中 LinkedBlockingQueue
         * 使用 LinkedBlockingQueue 无界队列，可能导致OOM
         */

        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executorService.submit(() -> {
                try {
                    System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


    }
}
