package com.chenyi.study.model;

import com.chenyi.study.toolkit.baseinfo.BaseModel;


import lombok.Data;

/**
 * user
 */
@Data
public class User extends BaseModel {
    /**
     * userName
     */
    private String userName;

    /**
     * telephone
     */
    private String telephone;

    /**
     * loginName
     */
    private String loginName;
}