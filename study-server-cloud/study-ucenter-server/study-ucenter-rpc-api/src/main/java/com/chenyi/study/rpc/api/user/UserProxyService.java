package com.chenyi.study.rpc.api.user;


import com.chenyi.study.ucenter.model.user.UserRole;

/**
 * @author chenyi65536@163.com
 * @date 2021/3/24-14:29
 * @description
 */
public interface UserProxyService {

    void insertUserAndRole(UserRole userRole);

}
