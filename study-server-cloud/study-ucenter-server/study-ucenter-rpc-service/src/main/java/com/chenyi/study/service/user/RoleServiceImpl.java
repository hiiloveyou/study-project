package com.chenyi.study.service.user;

import com.chenyi.study.rpc.api.user.RoleService;
import com.chenyi.study.ucenter.mapper.user.RoleMapper;
import com.chenyi.study.ucenter.model.user.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public int updateBatch(List<Role> list) {
        return roleMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Role> list) {
        return roleMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Role> list) {
        return roleMapper.batchInsert(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public int insertOrUpdate(Role record) {
        roleMapper.insertOrUpdate(record);
        throw new RuntimeException("insert user error");
//        return 1;
    }

    @Override
    public int insertOrUpdateSelective(Role record) {
        return roleMapper.insertOrUpdateSelective(record);
    }

}
