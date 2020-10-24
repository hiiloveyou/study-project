package com.chenyi.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author BG344144
 */
@SpringBootApplication
//@MapperScan(basePackages = {"com.chenyi.study.**.mapper"})
public class StudyUtilApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyUtilApplication.class, args);
    }
}
