package com.chenyi.study.controller;


import com.chenyi.study.model.User;
import com.chenyi.study.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class AjaxUserController {
    private final UserService userService;

    @GetMapping(value = "/findByUserBId")
    public User findByUserName(@RequestParam Long userId) {
        return userService.selectByPrimaryKey(userId);
    }
}
