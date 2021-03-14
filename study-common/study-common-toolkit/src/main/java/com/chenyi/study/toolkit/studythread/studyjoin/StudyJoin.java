package com.chenyi.study.toolkit.studythread.studyjoin;

/**
 * @author chenyi
 * @date 2021/3/14
 */
public class StudyJoin extends Thread {

    public StudyJoin(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(this.getName() + "-参数" + i + "-优先级" + this.getPriority());
        }
    }

    public static void main(String[] args) {

        final DaemonThread daemonThread = new DaemonThread("守护线程");
        //启动之前要设置好，前台线程执行完后，后台线程会自动死亡
        daemonThread.setDaemon(true);
        daemonThread.start();

        new StudyJoin("新线程").start();


        //指定优先级
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() +
                    "-参数" + i +
                    "-优先级" + Thread.currentThread().getPriority() +
                    "-是否是守护线程" + Thread.currentThread().isDaemon());
            if (i == 2) {
                final StudyJoin studyJoin = new StudyJoin("被Join的线程");
                studyJoin.setPriority(Thread.MAX_PRIORITY);
                studyJoin.start();
                try {
                    //调用join方法，主线程会被阻塞，知道被join的方法执行完成
                    studyJoin.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //线程回到RUNNABLE状态
            //Thread.yield();
        }


    }

    private static class DaemonThread extends Thread {

        public DaemonThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(this.getName() + "-" + i);
            }
        }
    }
}
