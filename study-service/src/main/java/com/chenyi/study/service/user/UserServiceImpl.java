package com.chenyi.study.service.user;

import com.chenyi.study.mapper.user.PermissionMapper;
import com.chenyi.study.mapper.user.RoleMapper;
import com.chenyi.study.mapper.user.UserMapper;
import com.chenyi.study.model.user.User;
import com.chenyi.study.vo.RoleVO;
import com.chenyi.study.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;
    private final PermissionMapper permissionMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public int updateBatch(List<User> list) {
        return userMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<User> list) {
        return userMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<User> list) {
        return userMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(User record) {
        return userMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(User record) {
        return userMapper.insertOrUpdateSelective(record);
    }

    @Override
    public User findByLoginName(String loginName) {
        return userMapper.findByLoginName(loginName);
    }

    @Override
    public Set<String> findRolesByLoginName(String loginName) {
        return userMapper.findRolesByLoginName(loginName);
    }

    @Override
    public Set<String> findPermissionsByLoginName(String loginName) {
        return userMapper.findPermissionsByLoginName(loginName);
    }

    @Override
    public UserVO findUserVOByLoginName(String loginName) {
        final UserVO userVO = new UserVO();
        final User user = userMapper.findByLoginName(loginName);
        BeanUtils.copyProperties(user, userVO);
        //装配角色
        final List<RoleVO> roleVOList = roleMapper.findVOByUserId(user.getId());
        userVO.setRoleVOList(roleVOList);
        //装配权限
        roleVOList.forEach(roleVO -> roleVO.setPermissionVOList(permissionMapper.findVOByRoleId(roleVO.getId())));
        return userVO;
    }
}
