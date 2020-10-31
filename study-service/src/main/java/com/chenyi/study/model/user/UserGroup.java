package com.chenyi.study.model.user;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * study_user_group
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserGroup extends BaseModel {
    public static final String COL_ID = "id";
    public static final String COL_CREATE_NAME = "create_name";
    public static final String COL_CREATE_ID = "create_id";
    public static final String COL_CREATE_TIME = "create_time";
    public static final String COL_UPDATE_NAME = "update_name";
    public static final String COL_UPDATE_ID = "update_id";
    public static final String COL_UPDATE_TIME = "update_time";
    public static final String COL_LOCK_VERSION = "lock_version";
    public static final String COL_USER_GROUP_NAME = "user_group_name";
    public static final String COL_USER_GROUP_CODE = "user_group_code";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_PRINCIPAL = "principal";
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