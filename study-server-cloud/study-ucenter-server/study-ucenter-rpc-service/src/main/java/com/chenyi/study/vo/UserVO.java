package com.chenyi.study.vo;

import lombok.Data;

import java.util.List;

@Data
public class UserVO extends BaseVo {
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
     * 用户当前状态
     */
    private Integer status;
    /**
     * 用户描述
     */
    private String description;
    /**
     * 用户的角色信息
     */
    private List<RoleVO> roleVOList;

}
