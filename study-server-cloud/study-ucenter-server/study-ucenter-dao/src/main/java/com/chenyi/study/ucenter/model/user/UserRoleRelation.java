package com.chenyi.study.ucenter.model.user;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import lombok.Data;

@Data
public class UserRoleRelation extends BaseModel {
    private Long userId;
    private Long roleId;
}
