package com.chenyi.study.toolkit.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.net.URI;
import java.util.Scanner;

/**
 * Java IO流学习
 * 1.输入流，输出流
 * 2.字节流，字符流
 * 3.节点流，处理流
 * 接口
 * Closeable
 * Flushable
 * Serializable
 * Externalizable
 * 关键字
 * transient 不可序列化
 * 类
 * File
 * InputStream/OutputStream
 * Reader/Writer
 * InputStreamReader/OutputStreamWriter
 * FileInputStream/FileOutputStream
 * FileReader/FileWriter
 * BufferedInputStream/BufferedOutputStream
 * BufferedReader/BufferedWriter  readLine()方法，可读一行
 * ByteArrayInputStream/ByteArrayOutputStream
 * CharArrayReader/CharArrayWriter
 * PrintStream/PrintWriter
 * DataInput/DataOutput
 * DataInputStream/DataOutputStream
 * ObjectInput/ObjectOutput
 * ObjectInputStream/ObjectOutputStream
 * StringReader/StringWriter
 *
 * @author chenyi
 * @date 2020/11/2
 */
public class StudyIO {

    private static final String pathName = "/Users/chenyi/Desktop/study-util/file/test.txt";
    private static Log log = LogFactory.getLog(StudyIO.class);

    public static void main(String[] args) throws Exception {
//        testFile();
//        fileInputOutputStream();
//        fileInputOutputStreamBytes();
//        byteArrayInputOutputStream();
//        bufferedInputOutputStream();
//        fileReaderWriter();
//        fileStreamToChar();
//        dataInputOutputStream();
//        objectStream();
//        printStream();
        systemInPrintAndOut();
    }

    /**
     * 文件一些属性
     *
     * @throws IOException
     */
    private static void testFile() throws IOException {
        final File file = new File("file/parent/child/childFile.txt");
        //pathname
        System.out.println("getPath = " + file.getPath());
        //绝对路径
        System.out.println("getAbsolutePath = " + file.getAbsolutePath());
        //文件名称，最后分隔符的那个
        System.out.println("getName = " + file.getName());
        //合规的路径，如果有相对路径会转换
        System.out.println("getCanonicalPath() = " + file.getCanonicalPath());
        System.out.println("getParent = " + file.getParent());
        System.out.println("getParentFile() = " + file.getParentFile().getName());

        //以父类作为路径+子类的路径
        final File file1 = new File("classpath:file/parent/parentFile.txt",
                "classpath:file/parent/child/childFile.txt");
        System.out.println("file1 = " + file1.getParent());

        File file3 = new File(URI.create("file:/Users/chenyi/Desktop/study-util/login1.jpg"));
        System.out.println("isDirectory = " + file3.isDirectory());
        System.out.println("isFile = " + file3.isFile());
        System.out.println("getParent = " + file3.getParent());
    }

    /**
     * 输入输出流字节流
     */
    private static void fileInputOutputStream() throws IOException {
        int b;
        final File file = new File(pathName);
        //如果文件不存在，新建文件
        if (!file.exists()) {
            final boolean newFile = file.createNewFile();
            if (!newFile) throw new IOException("file create fail");
        }
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(new File(
                        URI.create("file:/Users/chenyi/Desktop/study-util/file/fileOut.txt")), true)) {
            while ((b = fileInputStream.read()) != -1) {
                fileOutputStream.write(b);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            System.out.println("out file fail");
        }
        System.out.println("success");
    }

    /**
     * 字节流使用byte[]数组
     */
    private static void fileInputOutputStreamBytes() {
        int b;
        try (FileInputStream fileInputStream = new FileInputStream(new File(
                URI.create("file:/Users/chenyi/Desktop/study-util/file/out.txt")));
             FileOutputStream fileOutputStream = new FileOutputStream(new File(
                     URI.create("file:/Users/chenyi/Desktop/study-util/file/fileOutByte.txt")), false)) {

            byte[] bytes = new byte[1024];
            while ((b = fileInputStream.read(bytes, 0, 1024)) != -1) {
                fileOutputStream.write(bytes, 0, b);
            }
            fileOutputStream.flush();
        } catch (IOException e) {
            System.out.println("out file fail");
        }
        System.out.println("success");
    }

    /**
     * ByteArrayOutputStream
     * ByteArrayInputStream
     * 都是内存里面的流
     */
    private static void byteArrayInputOutputStream() {
        try (final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             final DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        ) {
            dataOutputStream.writeBytes("hello world");
            final byte[] bytes = byteArrayOutputStream.toByteArray();
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            final DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            System.out.println(dataInputStream.readLine());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 字节缓冲流
     */
    private static void bufferedInputOutputStream() {
        int b;
        try (FileInputStream fileInputStream = new FileInputStream(new File(
                URI.create("file:/Users/chenyi/Desktop/study-util/file/test.txt")));
             FileOutputStream fileOutputStream = new FileOutputStream(new File(
                     URI.create("file:/Users/chenyi/Desktop/study-util/file/bufferedOut.txt")), false);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ) {

            byte[] bytes = new byte[1024];

            while ((b = bufferedInputStream.read(bytes, 0, 1024)) != -1) {
                bufferedOutputStream.write(bytes, 0, b);
            }
        } catch (IOException e) {
            System.out.println("out file fail");
        }
        System.out.println("success");
    }

    /**
     * 字符流，包装成缓冲字符流
     */
    private static void fileReaderWriter() {
        int b;
        try (FileReader fileReader = new FileReader(new File(
                URI.create("file:/Users/chenyi/Desktop/study-util/file/test.txt")));
             FileWriter fileWriter = new FileWriter(new File(
                     URI.create("file:/Users/chenyi/Desktop/study-util/file/writerOut.txt")), false);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            //按字节数组读取
            char[] bytes = new char[1024];
            while ((b = bufferedReader.read(bytes, 0, 1024)) != -1) {
                bufferedWriter.write(bytes, 0, b);
            }

            //按行读取
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("out file fail");
        }
        System.out.println("success");
    }

    /**
     * 转换流，字节转字符
     */
    private static void fileStreamToChar() {
        int b;
        try (FileInputStream fileInputStream = new FileInputStream(new File(
                URI.create("file:/Users/chenyi/Desktop/study-util/file/test.txt")));
             FileOutputStream fileOutputStream = new FileOutputStream(new File(
                     URI.create("file:/Users/chenyi/Desktop/study-util/file/StreamToCharOut.txt")), false);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
             final InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
             final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream);
        ) {

            //按字节数组读取
            char[] bytes = new char[1024];
            while ((b = inputStreamReader.read(bytes, 0, 1024)) != -1) {
                outputStreamWriter.write(bytes, 0, b);
            }
        } catch (IOException e) {
            System.out.println("out file fail");
        }
        System.out.println("success");
    }


    /**
     * 数据流和字节数组流，Java原始类型， primitive Java data types
     */
    private static void dataInputOutputStream() {
        try (
                //内存新建一个字节数组
                final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                //包装为对象输出流
                final DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        ) {

            //将对象写入字节输出流中
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeDouble(0.1214);

            //从输出流转为字节数组输入流
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            //占用9个字节，byte1位，double 8位
            System.out.println(byteArrayInputStream.available());

            //包装为对象输入流
            final DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            //读取数据 ，先写的先读，顺序错了就不对了
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readDouble());
        } catch (IOException e) {
            System.out.println("data input error");
        }
    }

    /**
     * 对象流, 直接将Object对象读入或者写出
     * 序列化
     */
    private static void objectStream() throws Exception {
        //可序列化对象
        final T t = new T();

        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        //将可序列化的对象写入内存
        objectOutputStream.writeObject(t);
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        final ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        final T TConstant = (T) objectInputStream.readObject();
        System.out.println("TConstant = " + "name" + TConstant.name + ",age=" + TConstant.age +
                ",sex=" + TConstant.sex);

    }

    /**
     * 打印流，只有输出流
     * 替换标准的输出为打印
     */
    private static void printStream() throws Exception {
        final PrintStream printStream =
                new PrintStream("/Users/chenyi/Desktop/study-util/file/printOut.dat");
        //替换标准输出
        System.setOut(printStream);
        //将文本打印到文件
        int in = 0;
        for (char i = 0; i < 60000; i++) {
            System.out.print(i + " ");
            if (in++ >= 100) {
                System.out.println();
                in = 0;
            }
        }
    }

    /**
     * 标准输入输出
     */
    private static void systemInPrintAndOut() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             final PrintWriter printWriter = new PrintWriter(new FileWriter(
                     "/Users/chenyi/Desktop/study-util/file/printOutBuffered.log", true));
        ) {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                if ("exit".equalsIgnoreCase(string)) {
                    System.out.println("exit");
                    printWriter.println("-----");
                    printWriter.println("exit");
                    printWriter.flush();
                    break;
                }
                System.out.println("begin print:" + string);
                printWriter.println("******");
                printWriter.println(string.toUpperCase());
                printWriter.println(string);
                printWriter.println("******");
                printWriter.flush();
            }

        } catch (Exception exception) {
            System.out.println("print error");
        }
    }

    /**
     * 扫描输入流
     */
    private static void scannerIn() {
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //如果没有下一行了
            System.out.println(scanner.nextLine());
        }
        System.out.println("exit");
    }

}


class T
        implements Serializable {
    String name = "chenyi";
    int age = 27;
    //不可被序列化
    transient String sex = "man";
}