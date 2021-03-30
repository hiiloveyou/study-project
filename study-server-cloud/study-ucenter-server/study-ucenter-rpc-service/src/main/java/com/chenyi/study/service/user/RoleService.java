package com.chenyi.study.service.user;

import com.chenyi.study.model.user.Role;

import java.util.List;

public interface RoleService {


    int updateBatch(List<Role> list);

    int updateBatchSelective(List<Role> list);

    int batchInsert(List<Role> list);

    int insertOrUpdate(Role record);

    int insertOrUpdateSelective(Role record);

}
