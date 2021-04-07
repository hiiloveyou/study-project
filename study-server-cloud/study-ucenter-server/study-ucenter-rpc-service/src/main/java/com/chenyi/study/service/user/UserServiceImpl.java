package com.chenyi.study.service.user;

import com.chenyi.study.rpc.api.user.UserService;
import com.chenyi.study.rpc.api.vo.UserVO;
import com.chenyi.study.ucenter.mapper.user.PermissionMapper;
import com.chenyi.study.ucenter.mapper.user.RoleMapper;
import com.chenyi.study.ucenter.mapper.user.UserMapper;
import com.chenyi.study.ucenter.model.user.Role;
import com.chenyi.study.ucenter.model.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final String USER_INFO = "userInfo";

    private final UserMapper userMapper;
    private final RoleMapper roleMapper;
    private final PermissionMapper permissionMapper;

//    @Resource(name = "redisTemplate")
//    private final HashOperations hashOperations;

    // inject the actual template
//    @Autowired
//    private RedisTemplate<String, String> template;

    // inject the template as ListOperations
//    @Resource(name="redisTemplate")
//    private ListOperations<String, String> listOps;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(User user) {
        userMapper.insertOrUpdate(user);

//        redisTemplate.execute(RedisConnection::stringCommands);

//        hashOperations.put(USER_INFO, user.getLoginName(), user);


//        final User redisCacheUserInfo = (User) hashOperations.get(USER_INFO, user.getLoginName());
//        log.info("redisCacheUserInfo is {}", redisCacheUserInfo);
//        redisTemplate.exec()

//        final Role role = new Role();
//        role.setRoleName("testRole");
//        role.setStatus("1");
//        final List<Role> roles = new ArrayList<>();
//        roles.add(role);
//        roleService.batchInsert(roles);
//        userMapper.insert(user);
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
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public int insertOrUpdate(User record) {
        final int i = userMapper.insertOrUpdate(record);
//        throw new RuntimeException("insert user error");
         return 1;
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
        final List<Role> roleVOList = roleMapper.findVOByUserId(user.getId());
//        userVO.setRoleVOList(roleVOList);
        //装配权限
//        roleVOList.forEach(roleVO -> roleVO.setPermissionVOList(permissionMapper.findVOByRoleId(roleVO.getId())));
        return userVO;
    }
}
