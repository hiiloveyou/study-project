package com.chenyi.study.model.user;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * study_role
 */
@ApiModel(value = "com-chenyi-study-model-user-Role")
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "study_role")
public class Role extends BaseModel {
    /**
     * roleName
     */
    @Column(name = "role_name")
    @ApiModelProperty(value = "roleName")
    private String roleName;

    /**
     * status
     */
    @Column(name = "`status`")
    @ApiModelProperty(value = "status")
    private String status;
}