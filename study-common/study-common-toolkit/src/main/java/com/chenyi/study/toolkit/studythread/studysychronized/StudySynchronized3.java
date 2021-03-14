package com.chenyi.study.toolkit.studythread.studysychronized;

import java.math.BigDecimal;

/**
 * @author chenyi
 * @date 2021/3/14
 * 线程处于 NEW RUNNABLE WAITING TIMED_WAITING
 */
public class StudySynchronized3 extends Thread {

    private final Account3 account3;
    private final BigDecimal drawAmount;

    public StudySynchronized3(String name, Account3 account3, BigDecimal drawAmount) {
        super(name);
        this.account3 = account3;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        account3.draw(drawAmount);
    }

    public static void main(String[] args) {
        final Account3 account3 = new Account3("0001客户", BigDecimal.valueOf(1000));
        final Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new StudySynchronized3("客户" + i, account3, BigDecimal.valueOf(600));
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(threads[i].getName() + "启动前状态" + threads[i].getState());
            threads[i].start();
            try {
                //有延迟，等待一会在查询
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }

            System.out.println(threads[i].getName() + "启动后状态" + threads[i].getState());
        }


    }

}
