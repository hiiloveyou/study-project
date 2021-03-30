package com.chenyi.study.ucenter.model.user;

import lombok.Data;

/**
 * @author chenyi65536@163.com
 * @date 2021/3/24-14:42
 * @description
 */
@Data
public class UserRole {
    private User user;
    private Role role;
}
