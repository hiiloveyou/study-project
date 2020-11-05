package com.chenyi.study.toolkit.utils;

import java.io.*;
import java.net.URI;
import java.util.Scanner;

/**
 * @author chenyi
 * @date 2020/11/2
 */
public class StudyFile {
    public static void main(String[] args) {
//        file();
//        inoutOutputStream();
//        inoutOutputStreamByte();
//        inoutOutputStreamBuffer();
//        inOutReaderWriter();
//        inOutStreamToChar();
//        systemInOut();
//        scannerIn();
        dataStream();
    }

    /**
     * 文件
     */
    private static void file() {
        try {
            File file = new File(URI.create("file:/Users/chenyi/Desktop/study-util/login1.jpg"));
            new File(file.getPath().substring(0, file.getPath().lastIndexOf("login1")) + "/inner").mkdir();

            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(1);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            System.out.println("io fail");
        }

    }

    /**
     * 输入输出流字节流
     */
    private static void inoutOutputStream() {
        int b;
        try (FileInputStream fileInputStream = new FileInputStream(new File(
                URI.create("file:/Users/chenyi/Desktop/study-util/file/out.txt")));
             FileOutputStream fileOutputStream = new FileOutputStream(new File(
                     URI.create("file:/Users/chenyi/Desktop/study-util/file/out2.txt")), true)) {
            while ((b = fileInputStream.read()) != -1) {
                fileOutputStream.write(b);
            }
            fileOutputStream.flush();
        } catch (IOException e) {
            System.out.println("out file fail");
        }
        System.out.println("success");
    }

    /**
     * 字节流使用byte[]数组
     */
    private static void inoutOutputStreamByte() {
        int b;
        try (FileInputStream fileInputStream = new FileInputStream(new File(
                URI.create("file:/Users/chenyi/Desktop/study-util/file/out.txt")));
             FileOutputStream fileOutputStream = new FileOutputStream(new File(
                     URI.create("file:/Users/chenyi/Desktop/study-util/file/out2.txt")), false)) {

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
     * 字节缓冲流
     */
    private static void inoutOutputStreamBuffer() {
        int b;
        try (FileInputStream fileInputStream = new FileInputStream(new File(
                URI.create("file:/Users/chenyi/Desktop/study-util/file/out.txt")));
             FileOutputStream fileOutputStream = new FileOutputStream(new File(
                     URI.create("file:/Users/chenyi/Desktop/study-util/file/out2.txt")), false);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ) {

            byte[] bytes = new byte[1024];

            while ((b = bufferedInputStream.read(bytes, 0, 1024)) != -1) {
                bufferedOutputStream.write(bytes, 0, b);
            }
            bufferedOutputStream.flush();
        } catch (IOException e) {
            System.out.println("out file fail");
        }
        System.out.println("success");
    }

    /**
     * 字符流
     */
    private static void inOutReaderWriter() {
        int b;
        try (FileReader fileReader = new FileReader(new File(
                URI.create("file:/Users/chenyi/Desktop/study-util/file/out.txt")));
             FileWriter fileWriter = new FileWriter(new File(
                     URI.create("file:/Users/chenyi/Desktop/study-util/file/out2.txt")), false);
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
    private static void inOutStreamToChar() {
        int b;
        try (FileInputStream fileInputStream = new FileInputStream(new File(
                URI.create("file:/Users/chenyi/Desktop/study-util/file/out.txt")));
             FileOutputStream fileOutputStream = new FileOutputStream(new File(
                     URI.create("file:/Users/chenyi/Desktop/study-util/file/out2.txt")), false);
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
            outputStreamWriter.flush();
        } catch (IOException e) {
            System.out.println("out file fail");
        }
        System.out.println("success");
    }

    /**
     * 标准输入输出
     */
    private static void systemInOut() {
        //将标准输入流打印输出
        try (
                //定义标准输入
                final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                //定义标准输出
                final PrintStream printStream = System.out;
        ) {

            String string;
            //如果有输入就打印，否则推出
            while ((string = bufferedReader.readLine()).length() != 0) {
                printStream.println(string);
            }
            if (bufferedReader.readLine().equals("")) {
                System.out.println("<<<<<return>>>>>");
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("print error");
        }
        //为什么没有打印？？
        System.out.println("<<<<<exit>>>>>");
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

    /**
     * 数据流和字节数组流
     */
    private static void dataStream() {
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
            System.out.println(dataInputStream.readDouble());
            System.out.println(dataInputStream.readBoolean());
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    /**
     * 打印流
     */
    private static void printStream() throws FileNotFoundException {
//        new PrintStream("");
//        new PrintWriter("");
//        都有 auto flush 方法
    }

    /**
     * 对象流
     */
    private static void objectStream() {
//        new ObjectOutputStream()
    }

}
