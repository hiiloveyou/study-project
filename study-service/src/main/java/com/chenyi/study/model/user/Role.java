package com.chenyi.study.model.user;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * study_role
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "study_role")
public class Role extends BaseModel {
    /**
     * roleName
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * status
     */
    @Column(name = "`status`")
    private String status;
}