package com.chenyi.study.toolkit.studythread.studysychronized;

import java.math.BigDecimal;

/**
 * @author chenyi
 * @date 2021/3/14
 * 线程处于 NEW RUNNABLE WAITING TIMED_WAITING
 */
public class StudySynchronized2 extends Thread {

    private final Account2 account2;
    private final BigDecimal drawAmount;

    public StudySynchronized2(String name, Account2 account2, BigDecimal drawAmount) {
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
            threads[i] = new StudySynchronized2("客户" + i, account2, BigDecimal.valueOf(600));
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
