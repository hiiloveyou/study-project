package com.chenyi.study.model.user;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import lombok.Data;

@Data
public class OrganizationRoleRelation extends BaseModel {
    private Long organizationId;
    private Long roleId;
}
