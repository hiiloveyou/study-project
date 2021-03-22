package com.chenyi.study.toolkit.studythread.studysychronized;

import java.math.BigDecimal;

/**
 * @author chenyi
 * @date 2021/3/14
 * 演示锁处于 BLOCKED 状态
 */
public class Account3 {
    private final String accountNo;
    private BigDecimal balance;

    public Account3(String accountNo, BigDecimal balance) {
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
            System.out.println(Thread.currentThread().getName() + "正在叫号，请取钱 ");
            System.out.println("账户余额 = " + balance);
            balance = balance.subtract(drawAmount);
            System.out.println("取款后的账户余额 = " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + "余额不足" + Thread.currentThread().getState());
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
