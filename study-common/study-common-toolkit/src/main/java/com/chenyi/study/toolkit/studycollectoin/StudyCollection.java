package com.chenyi.study.toolkit.studycollectoin;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author chenyi
 * @date 2021/3/6
 */
public class StudyCollection {

    public static void main(String[] args) {

        final Collection<String> books = new HashSet<>();
        books.add("aaa");
        books.add("aaa");
        books.add("bbb");
        books.add("ccc");
        books.add("ddd");

        final Iterator<String> iterator = books.iterator();


        //如果此处books被移除了，元素结果发生变动，根据fail-fast，报错
        //只能使用Iterator.remove()操作
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//            books.remove("aaa");
//        }

        //Stream流
        final Stream<String> stream = books.stream();
        final List<String> collect = books.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);

        //IntStream
        final IntStream intStream = IntStream.builder().add(1).add(2).build();
        intStream.max().orElse(0);

        //排序
        final LinkedList<String> linkedList = new LinkedList<>();
        linkedList.push("aaa");
        linkedList.offer("fff");
        linkedList.add("cccc");
        linkedList.set(1, "444");
        Collections.reverse(linkedList);
        Collections.reverseOrder(Collections.reverseOrder());
        System.out.println("linkedList = " + linkedList);


        //查询

        Collections.binarySearch(linkedList, "aaa");
        Collections.max(linkedList);
        Collections.frequency(linkedList, "ddd");

        //同步控制
        Collections.synchronizedCollection(linkedList);

        //设置不可改变对象
        Collections.singleton("aaa");
        Collections.singletonList("aaa");
        Collections.singletonMap("hello", "word");
        Collections.unmodifiableList(Arrays.asList());

        //

    }
}
