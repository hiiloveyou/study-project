package com.chenyi.study.toolkit.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.*;
import java.util.Map;
import java.util.SortedMap;

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

    public static void main(String[] args) throws CharacterCodingException {
//        byteBuffer();
//        fileChannel();
//        fileChannelRepeat();
        charSet();
    }


    /**
     * Buffer本质是一个数组，数据必须经过Buffer和Channel打交道，类似竹筒取水
     * Buffer抽象类，可以在底层字节数组上进行 get/set
     * 使用CharBuffer为例子
     */
    private static void byteBuffer() {
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

            //在0-position之间设置mark
            charBuffer.mark();
            //回到mark位置
            charBuffer.reset();

            //position-limit之间的元素
            charBuffer.remaining();
            charBuffer.hasRemaining();

            //取消mark，position=0
            charBuffer.rewind();

            //其他类型的Buffer
            final DoubleBuffer allocate = DoubleBuffer.allocate(10);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Channel 类似传统的流，将文件映射成 Buffer
     * 不能直接访问Channel中的数据，只能通过Buffer
     * 最常用 map(),read(),write()
     * 没有构造，通过传统的节点InputStream和OutputStream getChannel()方法
     * Channel接口有很多实现类
     * 例如
     * java.lang.Object
     * java.nio.channels.spi.AbstractInterruptibleChannel
     * java.nio.channels.FileChannel
     * <p>
     * 还有其他的Channel
     * DatagramChannel
     * Pipe.SourceChannel
     * ServerSocketChannel
     * SocketChannel
     * Pipe.SinkChannel
     * Pipe.SourceChannel
     */
    private static void fileChannel() {
        try (
                final FileInputStream fileInputStream = new FileInputStream(
                        "/Users/chenyi/IdeaProjects/study-project/study-common/study-common-toolkit" +
                                "/src/main/java/com/chenyi/study/toolkit/utils/StudyIO.java");
                final FileChannel fileInputStreamChannel = fileInputStream.getChannel();
                final FileOutputStream fileOutputStream = new FileOutputStream(
                        "/Users/chenyi/Desktop/study-project/file/channelOut.txt");
                final FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();
        ) {
            final int length = fileInputStream.available();
            //只读模式读取文件
            final MappedByteBuffer mappedByteBuffer =
                    fileInputStreamChannel.map(FileChannel.MapMode.READ_ONLY, 0, length);
            //输出
            fileOutputStreamChannel.write(mappedByteBuffer);
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }

    private static void fileChannelRepeat() {
        try (
                final FileInputStream fileInputStream = new FileInputStream(
                        "/Users/chenyi/IdeaProjects/study-project/study-common/study-common-toolkit" +
                                "/src/main/java/com/chenyi/study/toolkit/utils/StudyIO.java");
                final FileChannel fileInputStreamChannel = fileInputStream.getChannel();
                final FileOutputStream fileOutputStream = new FileOutputStream(
                        "/Users/chenyi/Desktop/study-project/file/channelOutRepeat.txt");
                final FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();
        ) {
            final int length = fileInputStream.available();
            //用于重复取水
            final ByteBuffer byteBuffer = ByteBuffer.allocate(256);
            //分批次读
            while (fileInputStreamChannel.read(byteBuffer) != -1) {
                //准备将数据输出，limit=position, position=0
                byteBuffer.flip();

                //region Description，使用字符集输出，必须在write之前
                final Charset charset = Charset.forName(StandardCharsets.ISO_8859_1.name());
                final CharsetDecoder charsetDecoder = charset.newDecoder();
                final CharBuffer charBuffer = charsetDecoder.decode(byteBuffer);
                System.out.println(charBuffer);
                //endregion

                //位置准备好后开始写入输出流，写的时候位置会变
                fileOutputStreamChannel.write(byteBuffer);
                //写完后清空再次写入，不clear会一直循环
                byteBuffer.clear();
            }
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }

    /**
     * 字符集
     * decode(ByteBuffer bb)  解码：将二进制字节流转为字符
     * encode(CharBuffer cb)  编码：将字符转为二进制字节流
     * encode(String str)
     * CharsetDecoder	newDecoder()
     * CharsetEncoder	newEncoder()
     */
    private static void charSet() throws CharacterCodingException {
        final SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
        for (Map.Entry<String, Charset> entry : stringCharsetSortedMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        //访问本地系统的文件编码格式
        System.out.println(System.getProperty("file.encoding"));
        //使用字符集的别名或者字符集对象
        final Charset charset = Charset.forName("UTF-8");
        //获取编码器，将char->byte
        final CharsetEncoder charsetEncoder = charset.newEncoder();
        final CharBuffer allocate = CharBuffer.allocate(256);
        final ByteBuffer byteBuffer = charsetEncoder.encode(allocate);
        //获取解码器，将byte->char
        final CharsetDecoder charsetDecoder = charset.newDecoder();
        final CharBuffer charBuffer = charsetDecoder.decode(byteBuffer);

        //StandardCharsets 代表常用的字符集合
        final Charset charset1 = StandardCharsets.UTF_8;
        //直接调用
        final ByteBuffer encode = charset1.encode("");
    }

}
