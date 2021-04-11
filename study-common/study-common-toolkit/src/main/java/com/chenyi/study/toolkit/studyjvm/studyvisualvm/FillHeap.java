package com.chenyi.study.toolkit.studyjvm.studyvisualvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author chenyi
 * @date 2021/4/11
 * <p>
 * -verbose:gc
 * -Xmx100m -Xms100m -XX:+UseSerialGC -XX:+HeapDumpOnOutOfMemoryError -Xverify:none
 */
public class FillHeap {

    static class OOMObject {
        //64KB
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        final ArrayList<OOMObject> objectArrayList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(10);
            objectArrayList.add(new OOMObject());
        }
//        System.gc();
    }


    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("waiting for input... please input something,end with return button");
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String inputString = bufferedReader.readLine();
        System.out.println("start fill... = " + inputString);
        fillHeap(1000);
        System.out.println("start gc...");
        //在方法退出后执行垃圾回收
        System.gc();
        System.out.println("waiting for input again...");
        bufferedReader.readLine();
    }

}


