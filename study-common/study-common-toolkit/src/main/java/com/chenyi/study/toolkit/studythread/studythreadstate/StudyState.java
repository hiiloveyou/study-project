package com.chenyi.study.toolkit.studythread.studythreadstate;

/**
 * @author chenyi
 * @date 2021/3/14
 * @description Thread状态包括很多种，学习各种状态之间转换的触发点和时机
 * Thread.currentThread().getState() 可获取线程的执行状态
 * <p>
 * NEW 状态 线程还未调用 start 时的状态
 * <p>
 * RUNNABLE 状态 线程执行start后方法状态变为
 * 包括READY和RUNNING，线程为RUNNABLE状态不一定在执行，只是获得了执行的权利，
 * 具体的执行还需要操作系统的调度
 * 线程Thread.yield后状态为就绪
 * <p>
 * BLOCKED 线程准备进入同步代码块或者同步方法块体时，为了获取监控锁时的的状态
 * <p>
 * WAITING 调用Object.wait，Thread.join，LockSupport.park时线程的状态
 * <p>
 * TIMED_WAITING 超时等待 Thread.sleep，Object.wait，Thread.join，LockSupport.parkNanos，LockSupport.parkUntil
 * <p>
 * TERMINATED 线程执行完成
 */
public class StudyState {

    public static void main(String[] args) {
        final Thread.State state = Thread.currentThread().getState();
        System.out.println("主线程状态 = " + state);

        final Thread thread = new Thread(new MyRunnable(), "线程状态");
        System.out.println("线程初始状态 = " + thread.getState());

        thread.start();
        System.out.println("线程开始后状态 = " + thread.getState());


        try {
            thread.wait();
            System.out.println("wait = " + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static class MyRunnable implements Runnable {
        private int j;

        @Override
        public void run() {
            for (j = 0; j < 100; j++) {

                if (j == 20) {
                    try {
                        Thread.sleep(100);
                        System.out.println("线程等待状态 = " + Thread.currentThread().getState());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
