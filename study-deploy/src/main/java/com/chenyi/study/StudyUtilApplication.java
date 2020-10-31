package com.chenyi.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author BG344144
 */
@EnableOpenApi
@SpringBootApplication
@MapperScan(basePackages = {"com.chenyi.study.**.mapper"})
public class StudyUtilApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyUtilApplication.class, args);
    }
}
