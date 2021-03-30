package com.chenyi.study.ucenter.model.user;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * study_user
 */
@Data
//@Entity
@EqualsAndHashCode(callSuper = true)
public class User extends BaseModel {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户手机号
     */
    private String telephone;

    /**
     * 用户登陆名
     */
    private String loginName;

    /**
     * 邮箱地址
     */
    private String emailAddress;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户盐值
     */
    private String salt;

    /**
     * 用户当前状态
     */
    private Integer status;

    /**
     * 用户描述
     */
    private String description;

    /**
     * 用户的盐=salt+loginName
     */
    public String getCredentialSalt() {
        return loginName + salt;
    }
}