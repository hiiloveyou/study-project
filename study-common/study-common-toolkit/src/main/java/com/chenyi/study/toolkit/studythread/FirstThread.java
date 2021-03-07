package com.chenyi.study.toolkit.studythread;

/**
 * @author chenyi
 * @date 2021/3/7
 */
public class FirstThread extends Thread {
    private int i;

    @Override
    public void run() {

        for (; i < 1000; i++) {
            System.out.println("threadName = " + Thread.currentThread().getName() + ";" + i);
//            System.out.println("thisName = " + this);
//            setName(getName() + "@" + System.currentTimeMillis());
        }
    }


    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            System.out.println("Thread.currentThread() = " + Thread.currentThread());

            if (i == 10) {
                final FirstThread firstThread = new FirstThread();
                final FirstThread firstThread2 = new FirstThread();

                firstThread.start();
                firstThread2.start();
            }

        }


    }
}
