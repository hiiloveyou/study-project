package com.chenyi.study.toolkit.utils;

import lombok.extern.slf4j.Slf4j;

import java.nio.CharBuffer;

/**
 * IO使用字节流读入内存进行处理，NIO使用内存映射文件的方式
 * NIO将文件或者文件的一段区域映射到内存中，这样就可以像访问内存一样访问文件，
 * 模拟的操作系统上虚拟内存的概念，其中Channel和Buffer是NIO的两个核心对象，
 * NIO中所有的数据都要通过Channel传输
 * Channel与传统的 InputStream 和 OutputStream 区别在于它提供类一个map()方法,该方法能够将
 * “一块数据”映射到内存去，如果说传统的io操作是面向字节流的，那么新io是面向块操作的。
 *
 * @author chenyi
 * @date 2020/11/8
 */
@Slf4j
public class StudyNIO {

    public static void main(String[] args) {
        buffer();

    }

    /**
     * Buffer抽象类
     * 使用CharBuffer为例子
     */
    private static void buffer() {
        try {
            //初始值 position=0, limit=capacity mark =
            final CharBuffer charBuffer = CharBuffer.allocate(8);
            System.out.println("charBuffer.position() = " + charBuffer.position());
            System.out.println("charBuffer.limit() = " + charBuffer.limit());
            System.out.println("charBuffer.capacity() = " + charBuffer.capacity());
            System.out.println("charBuffer.mark() = " + charBuffer.mark());

            //put char
            charBuffer.put('a');
            charBuffer.put('b');
            charBuffer.put('c');
            charBuffer.put("good");
            System.out.println("after put charBuffer.position() = " + charBuffer.position());
            System.out.println("after put charBuffer.limit() = " + charBuffer.limit());

            //<editor-fold desc="flip()方法作用替换">

            //put后position位置为空，输出为空
//            System.out.println("charBuffer.get()--- = " + charBuffer.get());
            //重新设置 position，类似flip position 设置
//            charBuffer.position(0);
            //重新设置 limit，类似flip limit 设置
//            charBuffer.limit(7);
            //设置完成后，可以读取
//            System.out.println("charBuffer.get()--- = " + charBuffer.get());
            //position移动put的字节数
            //</editor-fold>


            //limit=position, position=0
            charBuffer.flip();
            System.out.println("after flip charBuffer.position() = " + charBuffer.position());
            System.out.println("after flip charBuffer.limit() = " + charBuffer.limit());

            //可以再次put，会替换index=0 的字符a, position move char size
//            charBuffer.put('z');
//            System.out.println("charBuffer.get z = " + charBuffer.get(0));

            //relative get char position+=position
            final char c = charBuffer.get();
            System.out.println("get c1 = " + c);
            System.out.println("after relative get charBuffer.position() = " + charBuffer.position());
            System.out.println("after relative get charBuffer.limit() = " + charBuffer.limit());

            //position=0,limit=capacity
            charBuffer.clear();
            System.out.println("after clear charBuffer.position() = " + charBuffer.position());
            System.out.println("after clear charBuffer.limit() = " + charBuffer.limit());

            //absolute get position not change
            final char c2 = charBuffer.get(2);
            System.out.println("get c2 = " + c2);
            System.out.println("after absolute get charBuffer.position() = " + charBuffer.position());
            System.out.println("after absolute get charBuffer.limit() = " + charBuffer.limit());

            charBuffer.put('e');
            System.out.println("after put again charBuffer.position() = " + charBuffer.position());
            System.out.println("after put again charBuffer.limit() = " + charBuffer.limit());
            charBuffer.flip();
            final char c4 = charBuffer.get();
            System.out.println("get c4 = " + c4);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
