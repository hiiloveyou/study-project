package com.chenyi.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class AjaxLoginController {

    @GetMapping(value = "/loginPage")
    public String login() {
        return "login";
    }

}
