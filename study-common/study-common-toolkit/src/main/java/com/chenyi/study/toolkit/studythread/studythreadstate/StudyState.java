package com.chenyi.study.toolkit.studythread.studythreadstate;

import com.chenyi.study.toolkit.studythread.studysychronized.Account2;

import java.math.BigDecimal;

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
 * 线程处于 NEW RUNNABLE WAITING TIMED_WAITING
 */
public class StudyState extends Thread {

    private final Account2 account2;
    private final BigDecimal drawAmount;

    public StudyState(String name, Account2 account2, BigDecimal drawAmount) {
        super(name);
        this.account2 = account2;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        account2.draw(drawAmount);
    }

    public static void main(String[] args) {
        final Account2 account2 = new Account2("0001客户", BigDecimal.valueOf(1000));

        final Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new StudyState("客户" + i, account2, BigDecimal.valueOf(600));
        }

        for (int i = 0; i < 5; i++) {
            try {
                //线程睡眠后，正常扣钱
                Thread.sleep(2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threads[i].getName() + "启动前状态" + threads[i].getState());
            threads[i].start();
            System.out.println(threads[i].getName() + "启动后状态" + threads[i].getState());
        }


    }

}
