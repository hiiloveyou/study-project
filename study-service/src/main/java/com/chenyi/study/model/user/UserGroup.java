package com.chenyi.study.model.user;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import lombok.Data;

@Data
public class UserGroup extends BaseModel {
    private String userGroupName;
    private String userGroupCode;
    private String description;
    private String principal;
}
