package com.chenyi.study.model.user;


import com.chenyi.study.toolkit.baseinfo.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserGroupRelation extends BaseModel {
    private Long userId;
    private Long userGroupId;
}
