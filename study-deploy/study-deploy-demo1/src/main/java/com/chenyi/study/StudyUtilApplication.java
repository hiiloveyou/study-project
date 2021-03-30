package com.chenyi.study;

import com.chenyi.study.model.user.UserRole;
import com.chenyi.study.service.user.UserProxyService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BG344144
 */
//@EnableOpenApi
@SpringBootApplication
@MapperScan(basePackages = {"com.chenyi.study.**.mapper"})
@EnableStudyProject
@RestController
@RequestMapping(value = "/transactional")
public class StudyUtilApplication {
    @Autowired
    private UserProxyService userProxyService;

    public static void main(String[] args) {
        SpringApplication.run(StudyUtilApplication.class, args);
    }

    @PostMapping(value = "/addUserRole")
    public void add(@RequestBody UserRole userRole) {
        userProxyService.insertUserAndRole(userRole);
    }
}
