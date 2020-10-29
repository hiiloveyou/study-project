package com.chenyi.study.model.user;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import lombok.Data;

@Data
public class UserOrganizationRelation extends BaseModel {
    private Long userId;
    private Long organizationId;
}
