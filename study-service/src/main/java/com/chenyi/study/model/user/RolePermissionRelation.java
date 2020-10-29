package com.chenyi.study.model.user;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import lombok.Data;

@Data
public class RolePermissionRelation extends BaseModel {
    private Long roleId;
    private Long permissionId;
}
