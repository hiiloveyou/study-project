package com.chenyi.study.controller.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@Valid
@ApiModel
public class UserBO {
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "用户名名称")
    @NotBlank(message = "用户名，必填")
    private String userName;
    /**
     * 用户手机号
     */
    @ApiModelProperty(value = "用户手机号", name = "用户手机号")
    @NotBlank(message = "用户手机号，必填")
    private String telephone;
    /**
     * 用户登陆名
     */
    @ApiModelProperty(value = "用户登陆名", name = "用户登陆名")
    @NotBlank(message = "用户登陆名，必填")
    private String loginName;
    /**
     * 邮箱地址
     */
    @ApiModelProperty(value = "邮箱地址", name = "邮箱地址")
    @NotBlank(message = "邮箱地址，必填")
    private String emailAddress;
    /**
     * 用户类型
     */
    @ApiModelProperty(value = "用户类型", name = "用户类型")
    private String userType;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", name = "密码")
    @NotBlank(message = "密码，必填")
    private String password;
    /**
     * 用户描述
     */
    @ApiModelProperty(value = "用户描述", name = "用户描述")
    private String description;
}
