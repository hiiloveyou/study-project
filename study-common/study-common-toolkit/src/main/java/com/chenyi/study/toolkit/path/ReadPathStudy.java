package com.chenyi.study.toolkit.path;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/**
 * @author BG344144
 * @date 2020/12/9-20:33
 * @description
 */
public class ReadPathStudy {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        //通过classLoader读取
        final File file = new File(ClassLoader.getSystemResource("file/库存初始化导入模板.xlsx").toURI());
        System.out.println(file.exists());
        //通过spring 工具读取
        final File file1 = ResourceUtils.getFile("file/库存初始化导入模板.xlsx");
        System.out.println("file1 = " + file1.exists());
    }
}
