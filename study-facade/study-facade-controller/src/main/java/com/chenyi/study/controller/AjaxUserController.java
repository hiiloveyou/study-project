package com.chenyi.study.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class AjaxUserController {
//    private final UserService userService;
//
//    @GetMapping(value = "/findByUserBId")
//    public User findByUserName(@RequestParam Long userId) {
//        return userService.selectByPrimaryKey(userId);
//    }
}
