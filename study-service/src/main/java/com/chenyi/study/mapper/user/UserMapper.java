package com.chenyi.study.mapper.user;

import com.chenyi.study.model.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author BG344144
 */
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {
    int updateBatch(List<User> list);

    int updateBatchSelective(List<User> list);

    int batchInsert(@Param("list") List<User> list);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);

    User findByLoginName(@Param("loginName") String loginName);


}