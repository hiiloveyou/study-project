package com.chenyi.study.toolkit.studythread.studylock;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyi
 * @date 2021/3/14
 */
public class StudyLock implements Runnable {
    private final LockAccount lockAccount;
    private final ReentrantLock reentrantLock = new ReentrantLock();

    public StudyLock(LockAccount lockAccount) {
        this.lockAccount = lockAccount;
    }

    @Override
    public void run() {
        reentrantLock.lock();
        try {
            lockAccount.draw(BigDecimal.valueOf(600));
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        final LockAccount lockAccount = new LockAccount("0001", BigDecimal.valueOf(1000));
        final StudyLock studyLock = new StudyLock(lockAccount);

        new Thread(studyLock, "客户A").start();
        new Thread(studyLock, "客户B").start();
        new Thread(studyLock, "客户C").start();

    }
}
