package com.chenyi.study.model.user;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * study_user
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "study_user")
public class User extends BaseModel {
    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户手机号
     */
    @Column(name = "telephone")
    private String telephone;

    /**
     * 用户登陆名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 邮箱地址
     */
    @Column(name = "email_address")
    private String emailAddress;

    /**
     * 用户类型
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 用户盐值
     */
    @Column(name = "salt")
    private String salt;

    /**
     * 用户当前状态
     */
    @Column(name = "`status`")
    private String status;

    /**
     * 用户描述
     */
    @Column(name = "description")
    private String description;
}