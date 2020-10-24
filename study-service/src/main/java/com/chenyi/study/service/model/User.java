package com.chenyi.study.service.model;

import lombok.Data;

/**
 * @author BG344144
 * @date 2020/10/24-1:44
 * @description
 */
@Data
class User {
    private Long id;
    private String userName;
    private String telePhone;
    private String loginName;
    private String nickName;
}
