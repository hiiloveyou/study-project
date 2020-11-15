package com.chenyi.study.model.user;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chenyi
 * @date 2020/11/14
 */

/**
 * permission
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Permission extends BaseModel {
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