package com.chenyi.study.toolkit.studycollectoin;

import java.util.HashMap;

/**
 * @author chenyi
 * @date 2021/3/7
 */
public class StudyMap {

    public static void main(String[] args) {

        final HashMap<String, String> hashMap = new HashMap<>();

        final String putIfAbsent = hashMap.putIfAbsent("book", "article");
        System.out.println("putIfAbsent = " + putIfAbsent + ";" + hashMap);

        final String putIfAbsent1 = hashMap.putIfAbsent("book", "article");
        System.out.println("putIfAbsent1 = " + putIfAbsent1 + ";" + hashMap);

        hashMap.put("fruit", "apple");
        System.out.println("hashMap = " + hashMap);

        hashMap.merge("fruit", "orange", (s, s2) -> {
            return s + s2;
        });

        System.out.println("hashMapMerge = " + hashMap);


        hashMap.compute("fruit", (s, s2) -> s + s2);
        System.out.println("hashMap2 = " + hashMap);

    }
}
