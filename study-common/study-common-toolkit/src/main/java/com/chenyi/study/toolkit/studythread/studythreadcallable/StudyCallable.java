package com.chenyi.study.toolkit.studythread.studythreadcallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author chenyi
 * @date 2021/3/14
 */
public class StudyCallable {


    public static void main(String[] args) {

        //定义一个任务
        final FutureTask<String> futureTask = new FutureTask<>(() -> {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + i);
            }
            return "hello future task-" + i;
        });


        for (int i = 0; i < 50; i++) {
            System.out.println("main-thread-name = " + Thread.currentThread().getName() + "-" + i);

            //此时主线程还学会就绪执行，线程进入就绪状态，不一定立即执行，对应线程的状态
            if (i == 20) {

                //1.使用run
                //        futureTask.run();

                //2.使用Thread包装
                new Thread(futureTask, "futureTask-run").start();


//                futureTask.cancel(true);
                //        System.out.println("futureTask.isCancelled() = " + futureTask.isCancelled());

                try {
                    //主线程会进入阻塞状态，知道get方法执行完成
                    System.out.println("futureTask.get() = " + futureTask.get());
                    System.out.println("futureTask.isDone() = " + futureTask.isDone());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }

            }
        }


    }


}
