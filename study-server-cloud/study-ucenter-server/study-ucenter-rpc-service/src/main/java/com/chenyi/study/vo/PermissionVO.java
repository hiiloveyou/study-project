package com.chenyi.study.vo;

import lombok.Data;

/**
 * @author chenyi
 * @date 2020/11/21
 */
@Data
public class PermissionVO extends BaseVo {
    /**
     * url
     */
    private String url;

    /**
     * 权限类型：包括文件夹菜单，按钮等
     */
    private String permissionType;

    /**
     * permissionName
     */
    private String permissionName;

    /**
     * permissionCode
     */
    private String permissionCode;

    /**
     * path
     */
    private String path;

    /**
     * parentId
     */
    private Long parentId;

    /**
     * sortIndex
     */
    private Integer sortIndex;

    /**
     * description
     */
    private String description;
}
