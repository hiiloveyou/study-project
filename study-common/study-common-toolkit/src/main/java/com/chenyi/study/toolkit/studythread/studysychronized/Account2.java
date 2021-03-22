package com.chenyi.study.toolkit.studythread.studysychronized;

import java.math.BigDecimal;

/**
 * @author chenyi
 * @date 2021/3/14
 */
public class Account2 {
    private final String accountNo;
    private BigDecimal balance;

    public Account2(String accountNo, BigDecimal balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }


    public String getAccountNo() {
        return accountNo;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public synchronized void draw(BigDecimal drawAmount) {
        System.out.println(Thread.currentThread().getName() + "正在查询余额" + Thread.currentThread().getState());
        if (balance.compareTo(drawAmount) > 0) {
            try {
                //线程进入同步方法之后，等待时间会放弃同步锁，处于等待状态，
                // 因此对可变对象会有线程安全问题
                System.out.println(Thread.currentThread().getName() + "余额充足等待取钱");
                if (!Thread.currentThread().getName().equalsIgnoreCase("客户4")) {
                    //增加时间可有 TIMED_WAITING
//                    this.wait(100000);
                    this.wait();
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "叫号过期了 = " + e);
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在叫号，请取钱 ");
            System.out.println("账户余额 = " + balance);
            balance = balance.subtract(drawAmount);
            System.out.println("取款后的账户余额 = " + balance);
            if (Thread.currentThread().getName().equalsIgnoreCase("客户4")) {
                this.notify();
                System.out.println(Thread.currentThread().getName() + "当前状态" + Thread.currentThread().getState());
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "余额不足" + Thread.currentThread().getState());
        }
    }
}
