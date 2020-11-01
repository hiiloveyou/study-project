package com.chenyi.study.controller.intercepter;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author chenyi
 * @date 2020/11/1
 */
public class MyServlet extends HttpServletBean {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public ConfigurableEnvironment getEnvironment() {
        ConfigurableEnvironment environment = super.getEnvironment();
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        System.out.println(environment.getSystemProperties());
        return environment;
    }

}
