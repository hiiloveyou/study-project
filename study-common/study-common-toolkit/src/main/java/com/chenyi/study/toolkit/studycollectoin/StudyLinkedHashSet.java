package com.chenyi.study.toolkit.studycollectoin;

import java.util.LinkedHashSet;

/**
 * @author chenyi
 * @date 2021/3/6
 * 底层调用LinkedHashMap
 */
public class StudyLinkedHashSet {

    public static void main(String[] args) {

        final LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("cc");
        linkedHashSet.add("aa");
        linkedHashSet.add("dd");
        System.out.println("linkedHashSet1 = " + linkedHashSet);
        //按照插入的顺序维护
        linkedHashSet.remove("cc");
        linkedHashSet.add("cc");
        System.out.println("linkedHashSet2 = " + linkedHashSet);


    }
}
