package com.chenyi.study.service.user;

import com.chenyi.study.rpc.api.user.RoleService;
import com.chenyi.study.rpc.api.user.UserProxyService;
import com.chenyi.study.rpc.api.user.UserService;
import com.chenyi.study.ucenter.model.user.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenyi65536@163.com
 * @date 2021/3/24-14:30
 * @description
 */
@Service
@RequiredArgsConstructor
public class UserProxyServiceImpl implements UserProxyService {
    private final UserService userService;
    private final RoleService roleService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertUserAndRole(UserRole userRole) {

        userService.insertOrUpdate(userRole.getUser());


//        roleService.insertOrUpdate(userRole.getRole());
        throw new RuntimeException("insert user  role error");
    }


//    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)


}
