package com.chenyi.study.rpc.api.user;


import com.chenyi.study.ucenter.model.user.Role;

import java.util.List;

public interface RoleService {


    int updateBatch(List<Role> list);

    int updateBatchSelective(List<Role> list);

    int batchInsert(List<Role> list);

    int insertOrUpdate(Role record);

    int insertOrUpdateSelective(Role record);

}
