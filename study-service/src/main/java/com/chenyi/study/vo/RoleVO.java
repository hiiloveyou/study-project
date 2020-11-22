package com.chenyi.study.vo;

import lombok.Data;

import java.util.List;

/**
 * @author chenyi
 * @date 2020/11/21
 */
@Data
public class RoleVO extends BaseVo {
    /**
     * roleName
     */
    private String roleName;
    /**
     * status
     */
    private String status;
    /**
     * 角色拥有的权限
     */
    private List<PermissionVO> permissionVOList;
}
