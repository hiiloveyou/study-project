package com.chenyi.study.service.user;

import com.chenyi.study.model.user.User;
import com.chenyi.study.vo.UserVO;

import java.util.List;
import java.util.Set;

public interface UserService {

    void insert(User user);

    int updateBatch(List<User> list);

    int updateBatchSelective(List<User> list);

    int batchInsert(List<User> list);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);


    User findByLoginName(String loginName);

    /**
     * 查询用户所有角色
     *
     * @param loginName
     * @return
     */
    Set<String> findRolesByLoginName(String loginName);

    /**
     * 查询用户所有权限
     *
     * @param loginName
     * @return
     */
    Set<String> findPermissionsByLoginName(String loginName);

    /**
     * 查询登陆用户的角色权限信息
     *
     * @param loginName
     * @return
     */
    UserVO findUserVOByLoginName(String loginName);


}
