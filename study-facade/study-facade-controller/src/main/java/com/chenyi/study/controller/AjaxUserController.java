package com.chenyi.study.controller;


import com.chenyi.study.controller.bo.UserBO;
import com.chenyi.study.model.user.User;
import com.chenyi.study.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Api(tags = "用户页面API说明")
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class AjaxUserController {
    private final UserService userService;

    @ApiOperation(value = "根据用户登陆名查询用户信息", notes = "用户登陆名", tags = "1.0.0")
    @GetMapping(value = "/findByLoginName")
    public User findByUserName(@Validated @RequestParam String loginName) {
        return userService.findByLoginName(loginName);
    }

    @ApiOperation(value = "创建新用户", tags = "1.0.0")
    @PostMapping(value = "/addUser")
    public void addUser(@RequestBody @Valid UserBO userBO) {
        User user = new User();
        user.setUserName(userBO.getUserName());
        user.setTelephone(userBO.getTelephone());
        user.setLoginName(userBO.getLoginName());
        user.setEmailAddress(userBO.getEmailAddress());
        user.setUserType(userBO.getUserType());
        user.setPassword(userBO.getPassword());
        user.setSalt(UUID.randomUUID().toString());
        user.setStatus("ENABLE");
        user.setDescription(userBO.getDescription());
        userService.insert(user);
    }
}
