package com.chenyi.study.rpc.api.user;


import com.chenyi.study.rpc.api.vo.SysPermissionVo;
import com.chenyi.study.ucenter.model.user.Permission;

import java.util.List;

/**
 * @author chenyi
 * @date 2020/11/14
 */
public interface PermissionService {

    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertOrUpdate(Permission record);

    int insertOrUpdateSelective(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    Permission insertAndSelectByPrimaryKey(Permission record);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    int updateBatch(List<Permission> list);

    int updateBatchSelective(List<Permission> list);

    int batchInsert(List<Permission> list);

    List<SysPermissionVo> findAll();

}

