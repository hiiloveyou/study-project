package com.chenyi.study.service.user;

import com.chenyi.study.mapper.user.PermissionMapper;
import com.chenyi.study.model.user.Permission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenyi
 * @date 2020/11/14
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Permission record) {
        return permissionMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Permission record) {
        return permissionMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Permission record) {
        return permissionMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Permission record) {
        return permissionMapper.insertSelective(record);
    }

    @Override
    public Permission selectByPrimaryKey(Long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Permission record) {
        return permissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return permissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Permission> list) {
        return permissionMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Permission> list) {
        return permissionMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Permission> list) {
        return permissionMapper.batchInsert(list);
    }

}

