package com.chenyi.study.toolkit.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * NIO2
 * 1.提供全面的文件IO和文件系统访问支持 增加 java.nio.file以及子包
 * 2.基于异步Channel的IO，java.nio.channels包下增加Asynchronous开头的接口
 *
 * @author chenyi
 * @date 2020/11/10
 */
public class StudyNIO2 {
    public static void main(String[] args) throws IOException {
        file();
    }

    /**
     * Path
     * Paths
     */
    private static void path() {
        final Path path = Paths.get(".");
        //路径数量
        final int nameCount = path.getNameCount();
    }

    /**
     * Files
     */
    private static void file() throws IOException {
        final Path path = Paths.get("/Users/chenyi/Desktop/study-util/file/paths.txt");
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        final SeekableByteChannel seekableByteChannel = Files.newByteChannel(path, StandardOpenOption.WRITE);

        final CharBuffer charBuffer = CharBuffer.allocate(256);
        charBuffer.put("hello world");
        charBuffer.flip();
        final ByteBuffer byteBufferEncode = StandardCharsets.UTF_8.encode(charBuffer);
        seekableByteChannel.write(byteBufferEncode);
    }
}
