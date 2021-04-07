package com.chenyi.study.rpc.api.vo;

import lombok.Data;

@Data
public class SysPermissionVo {
    private Integer id;//主键.
    private String text;//名称.
    private String parent;//资源路径.
    private Boolean state;//状态
}