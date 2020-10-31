package com.chenyi.study.service.user;

import com.chenyi.study.model.user.User;

import java.util.List;

public interface UserService {

    void insert(User user);

    int updateBatch(List<User> list);

    int updateBatchSelective(List<User> list);

    int batchInsert(List<User> list);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);


    User findByLoginName(String loginName);


}
