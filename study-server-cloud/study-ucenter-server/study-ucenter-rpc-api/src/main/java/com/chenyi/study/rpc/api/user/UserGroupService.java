package com.chenyi.study.rpc.api.user;

import com.chenyi.study.ucenter.model.user.UserGroup;

import java.util.List;

public interface UserGroupService {


    int deleteByPrimaryKey(Long id);

    int insert(UserGroup record);

    int insertOrUpdate(UserGroup record);

    int insertOrUpdateSelective(UserGroup record);

    int insertSelective(UserGroup record);

    UserGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKey(UserGroup record);

    int updateBatch(List<UserGroup> list);

    int updateBatchSelective(List<UserGroup> list);

    int batchInsert(List<UserGroup> list);

}
