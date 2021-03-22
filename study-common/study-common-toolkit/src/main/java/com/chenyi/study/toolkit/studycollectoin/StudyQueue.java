package com.chenyi.study.toolkit.studycollectoin;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/**
 * @author chenyi
 * @date 2021/3/7
 */
public class StudyQueue {

    public static void main(String[] args) {

        final PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer("ccc");
        priorityQueue.offer("ddd");
        priorityQueue.offer("aaa");
        priorityQueue.offer("fff");
        priorityQueue.offer("bbb");

        System.out.println("priorityQueue = " + priorityQueue);
        System.out.println("priorityQueuePoll = " + priorityQueue.poll());
        System.out.println("priorityQueuePoll = " + priorityQueue.poll());
        System.out.println("priorityQueuePoll = " + priorityQueue.poll());
        System.out.println("priorityQueuePoll = " + priorityQueue.poll());
        System.out.println("priorityQueuePoll = " + priorityQueue.poll());


        final ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst("aaa");
        arrayDeque.addFirst("bbb");
        arrayDeque.addLast("eee");
        System.out.println("arrayDeque = " + arrayDeque);


        final String element = arrayDeque.element();
        System.out.println("element = " + element);

        arrayDeque.offer("ggg");
        System.out.println("arrayDequeOffer = " + arrayDeque);

        final String s = arrayDeque.peekLast();
        System.out.println("peekLast = " + s);


    }
}
