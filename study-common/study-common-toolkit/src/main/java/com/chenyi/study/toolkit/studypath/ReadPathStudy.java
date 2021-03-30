package com.chenyi.study.toolkit.studypath;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author chenyi65536@163.com
 * @date 2020/12/9-20:33
 * @description
 */
public class ReadPathStudy {
    private static Logger log = LoggerFactory.getLogger(ReadPathStudy.class);

    public static void main(String[] args) throws Exception {
        final String replace = StringUtils.replace("dsaf  dsfadsaf", " ", "%20");
        System.out.println("replace = " + replace);

        classLoaderFile();
        springResource();
        classPathResource();

        ClassUtils.getDefaultClassLoader();

    }

    private static void classLoaderFile() throws URISyntaxException {
        //通过classLoader读取
        final File classLoaderFileFile = new File(ClassLoader.getSystemResource("file/库存初始化导入模板.xlsx").toURI());
        System.out.println("file = " + classLoaderFileFile.exists());
        log.info("file {}", classLoaderFileFile.exists());
    }

    private static void springResource() throws FileNotFoundException {
        //通过spring 工具读取，需要加前缀 classpath转为URL
        final File springResourceFile = ResourceUtils.getFile("classpath:file/库存初始化导入模板.xlsx");
        System.out.println("springResourceFile = " + springResourceFile.exists());
    }

    private static void classPathResource() throws IOException {
        //通过spring 工具读取，需要加前缀 classpath转为URL
        final ClassPathResource classPathResource = new ClassPathResource("file/库存初始化导入模板.xlsx");


        final File classPathResourceFile = classPathResource.getFile();
        System.out.println("classPathResourceFile = " + classPathResourceFile.exists());
        System.out.println("classPathResourceFile = " + classPathResource.exists());
    }
}
