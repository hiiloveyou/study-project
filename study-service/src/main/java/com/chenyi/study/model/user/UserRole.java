package com.chenyi.study.model.user;

import lombok.Data;

/**
 * @author BG344144
 * @date 2021/3/24-14:42
 * @description
 */
@Data
public class UserRole {
    private User user;
    private Role role;
}
