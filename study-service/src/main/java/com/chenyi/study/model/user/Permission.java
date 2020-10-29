package com.chenyi.study.model.user;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import lombok.Data;

@Data
public class Permission extends BaseModel {
    private String url;
    /**
     * 权限类型：包括文件夹菜单，按钮等
     */
    private String permissionType;
    private String permissionName;
    private String permissionCode;
    private String path;
    private Long parentId;
    private Integer sortIndex;

}
