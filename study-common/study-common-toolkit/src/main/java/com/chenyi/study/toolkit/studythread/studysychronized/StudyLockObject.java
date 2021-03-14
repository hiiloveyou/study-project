package com.chenyi.study.toolkit.studythread.studysychronized;

import java.math.BigDecimal;
import java.util.concurrent.locks.LockSupport;

/**
 * @author chenyi
 * @date 2021/3/14
 */
public class StudyLockObject implements Runnable {
    private Account account;

    public StudyLockObject(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        synchronized (account) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "开始结账");
        }
    }

    public static void main(String[] args) {
        final StudyLockObject studyLockObject = new StudyLockObject(new Account("001", BigDecimal.ZERO));

        final Thread threadA = new Thread(studyLockObject, "threadA");
        threadA.start();
        final Thread threadB = new Thread(studyLockObject, "threadB");
        threadB.start();

        LockSupport.park(1000);

        System.out.println("threadA = " + threadA.getState());
        System.out.println("threadB = " + threadB.getState());
        LockSupport.unpark(Thread.currentThread());
    }
}
