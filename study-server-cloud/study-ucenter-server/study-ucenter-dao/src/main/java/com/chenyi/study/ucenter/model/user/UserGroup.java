package com.chenyi.study.ucenter.model.user;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * study_user_group
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserGroup extends BaseModel {
    /**
     * userGroupName
     */
    private String userGroupName;

    /**
     * userGroupCode
     */
    private String userGroupCode;

    /**
     * description
     */
    private String description;

    /**
     * principal
     */
    private String principal;
}