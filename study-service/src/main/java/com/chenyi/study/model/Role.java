package com.chenyi.study.model;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import lombok.Data;

@Data
public class Role extends BaseModel {
    private String roleName;
    private String roleShortName;
}
