package com.chenyi.study.toolkit.studyjvm.studyoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chenyi
 * @date 2021/4/11
 * @desciption 发生OOM的区域主要heap，method area，jvm stack
 * <p>
 * -Xmx20M -Xms10M
 */
public class StudyOOMInHeap {
    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) throws IOException {

        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        bufferedReader.readLine();

        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        final byte[] bytes1 = new byte[2 * _1M];
        final byte[] bytes2 = new byte[2 * _1M];
        final byte[] bytes3 = new byte[2 * _1M];
        final byte[] bytes4 = new byte[4 * _1M];

        while (true) {

        }

    }

}
