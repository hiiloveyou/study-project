package com.chenyi.study.ucenter.mapper.user;

import com.chenyi.study.model.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author chenyi65536@163.com
 */
public interface UserMapper
//        extends tk.mybatis.mapper.common.Mapper<User>
{
    int updateBatch(List<User> list);

    int updateBatchSelective(List<User> list);

    int batchInsert(@Param("list") List<User> list);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);

    User findByLoginName(@Param("loginName") String loginName);

    /**
     * 查询用户所有角色
     *
     * @param loginName
     * @return
     */
    Set<String> findRolesByLoginName(@Param("loginName") String loginName);

    /**
     * 查询用户所有权限
     *
     * @param loginName
     * @return
     */
    Set<String> findPermissionsByLoginName(@Param("loginName") String loginName);


}