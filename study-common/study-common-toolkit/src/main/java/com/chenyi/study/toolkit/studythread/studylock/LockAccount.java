package com.chenyi.study.toolkit.studythread.studylock;

import java.math.BigDecimal;

/**
 * @author chenyi
 * @date 2021/3/14
 */
public class LockAccount {
    private String accountNo;
    private BigDecimal balance;

    public LockAccount() {
    }

    public LockAccount(String accountNo, BigDecimal balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void draw(BigDecimal drawAmount) {
        System.out.println(Thread.currentThread().getName() + "正在查询余额" + Thread.currentThread().getState());
        if (balance.compareTo(drawAmount) > 0) {
            System.out.println("账户余额 = " + balance);
            balance = balance.subtract(drawAmount);
            System.out.println("取款后的账户余额 = " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + "余额不足" + Thread.currentThread().getState());
        }
    }

}
