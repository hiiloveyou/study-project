package com.chenyi.study.model.user;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * study_user
 */
@ApiModel(value = "com-chenyi-study-model-user-User")
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "study_user")
public class User extends BaseModel {
    /**
     * 用户名
     */
    @Column(name = "user_name")
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 用户手机号
     */
    @Column(name = "telephone")
    @ApiModelProperty(value = "用户手机号")
    private String telephone;

    /**
     * 用户登陆名
     */
    @Column(name = "login_name")
    @ApiModelProperty(value = "用户登陆名")
    private String loginName;

    /**
     * 邮箱地址
     */
    @Column(name = "email_address")
    @ApiModelProperty(value = "邮箱地址")
    private String emailAddress;

    /**
     * 用户类型
     */
    @Column(name = "user_type")
    @ApiModelProperty(value = "用户类型")
    private String userType;

    /**
     * 密码
     */
    @Column(name = "`password`")
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 用户盐值
     */
    @Column(name = "salt")
    @ApiModelProperty(value = "用户盐值")
    private String salt;

    /**
     * 用户当前状态
     */
    @Column(name = "`status`")
    @ApiModelProperty(value = "用户当前状态")
    private String status;

    /**
     * 用户描述
     */
    @Column(name = "description")
    @ApiModelProperty(value = "用户描述")
    private String description;
}