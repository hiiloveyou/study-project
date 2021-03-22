package com.chenyi.study.toolkit.studycollectoin;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author chenyi
 * @date 2021/3/6
 * 底层是红黑树
 */
public class StudyTreeSet {

    public static void main(String[] args) {

        final TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("ccc");
        treeSet.add("aaa");
        treeSet.add("ddd");
        treeSet.add("fff");

        System.out.println("treeSet = " + treeSet);

        treeSet.first();
        treeSet.last();

        treeSet.higher("gg");
        treeSet.lower("gg");


        treeSet.headSet("aa", true);
        treeSet.tailSet("bb", false);

        //不可以添加不同类型的对象，且该对象必须实现 Comparable接口

        //手动开启同步
        final SortedSet<Object> objects = Collections.synchronizedSortedSet(new TreeSet<>());

    }
}
