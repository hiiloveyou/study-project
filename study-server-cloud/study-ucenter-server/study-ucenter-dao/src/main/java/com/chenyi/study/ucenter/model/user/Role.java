package com.chenyi.study.ucenter.model.user;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * study_role
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseModel {
    /**
     * roleName
     */
    private String roleName;
    /**
     * status
     */
    private String status;
}