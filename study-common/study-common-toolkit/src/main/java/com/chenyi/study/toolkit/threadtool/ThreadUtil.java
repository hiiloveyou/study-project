package com.chenyi.study.toolkit.threadtool;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenyi
 * @date 2021/3/6
 */
public class ThreadUtil {


    public static void main(String[] args) {

        final MapThread mapThread = new MapThread();

        final Thread thread1 = new Thread(mapThread);
        final Thread thread2 = new Thread(mapThread);
        final Thread thread3 = new Thread(mapThread);
        final Thread thread4 = new Thread(mapThread);
        final Thread thread5 = new Thread(mapThread);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }


    static class MapThread implements Runnable {
        private static final AtomicInteger atomicInteger = new AtomicInteger();
        private static final HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        @Override
        public void run() {
            while (atomicInteger.get() < 1000000) {
                hashMap.put(atomicInteger.get(), atomicInteger.get());
                atomicInteger.incrementAndGet();
                System.out.println(atomicInteger.get());
            }
        }
    }
}
