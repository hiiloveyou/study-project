package com.chenyi.study.ucenter.mapper.user;

import com.chenyi.study.ucenter.model.user.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenyi65536@163.com
 */
public interface RoleMapper
//        extends tk.mybatis.mapper.common.Mapper<Role>
{
    int updateBatch(List<Role> list);

    int updateBatchSelective(List<Role> list);

    int batchInsert(@Param("list") List<Role> list);

    int insertOrUpdate(Role record);

    int insertOrUpdateSelective(Role record);

    List<Role> findVOByUserId(@Param("userId") Long userId);
}