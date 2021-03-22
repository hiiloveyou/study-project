package com.chenyi.study.toolkit.studycollectoin;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author chenyi
 * @date 2021/3/6
 * 底层调用HashMap
 */
public class StudyHashSet {


    public static void main(String[] args) {

        final HashSet<Node> nodeHashSet = new HashSet<>();
        nodeHashSet.add(new Node(1));
        nodeHashSet.add(new Node(2));
        nodeHashSet.add(new Node(3));
        System.out.println("nodeHashSet = " + nodeHashSet);

        final Iterator<Node> iterator = nodeHashSet.iterator();
        final Node next = iterator.next();
        //可变对象重新赋值
        next.count = 3;
        //发现有重复的元素
        System.out.println("nodeHashSet2 = " + nodeHashSet);
        //将原来的Node3移除
        nodeHashSet.remove(new Node(3));
        System.out.println("nodeHashSet3 = " + nodeHashSet);

        //此时没有包含Node3，只有可变的对象
        System.out.println("contains = " + nodeHashSet.contains(new Node(3)));


        //结论：HashSet存放可变对象时候，参与计算hashCode的方法不要是可变的实例变量

    }


    /**
     * HashSet中存入可变对象
     */
    static class Node {
        public int count;

        Node(int count) {
            this.count = count;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "count=" + count +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o.getClass() == Node.class) {
                if (((Node) o).count == count) {
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return count;
        }
    }

}
