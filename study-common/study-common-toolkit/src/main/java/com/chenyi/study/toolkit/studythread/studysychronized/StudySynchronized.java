package com.chenyi.study.toolkit.studythread.studysychronized;

import java.math.BigDecimal;

/**
 * @author chenyi
 * @date 2021/3/14
 * 线程不安全
 */
public class StudySynchronized extends Thread {
    private final Account account;
    private final BigDecimal drawAmount;

    public StudySynchronized(Account account, BigDecimal drawAmount) {
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        if (account.getBalance().compareTo(drawAmount) > 0) {
            System.out.println("客户" + this.getName() + "开始取钱 = " + this.getState());
            System.out.println("账户余额 = " + account.getBalance());
            account.setBalance(account.getBalance().subtract(drawAmount));
            System.out.println("取款后的账户余额 = " + account.getBalance());
        } else {
            System.out.println("客户" + this.getName() + "余额不足");
        }
    }

    public static void main(String[] args) {
        final Account account = new Account("10001号客户", BigDecimal.valueOf(1000));


        new StudySynchronized(account, BigDecimal.valueOf(600)).start();
        new StudySynchronized(account, BigDecimal.valueOf(600)).start();

    }

}
