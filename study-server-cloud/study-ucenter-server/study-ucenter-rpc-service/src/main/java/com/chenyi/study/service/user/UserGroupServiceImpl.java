package com.chenyi.study.service.user;

import com.chenyi.study.rpc.api.user.UserGroupService;
import com.chenyi.study.ucenter.mapper.user.UserGroupMapper;
import com.chenyi.study.ucenter.model.user.UserGroup;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserGroupServiceImpl implements UserGroupService {

    @Resource
    private UserGroupMapper userGroupMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserGroup record) {
        return userGroupMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(UserGroup record) {
        return userGroupMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UserGroup record) {
        return userGroupMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(UserGroup record) {
        return userGroupMapper.insertSelective(record);
    }

    @Override
    public UserGroup selectByPrimaryKey(Long id) {
        return userGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserGroup record) {
        return userGroupMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserGroup record) {
        return userGroupMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<UserGroup> list) {
        return userGroupMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<UserGroup> list) {
        return userGroupMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<UserGroup> list) {
        return userGroupMapper.batchInsert(list);
    }

}
