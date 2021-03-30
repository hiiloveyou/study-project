package com.chenyi.study.ucenter.mapper.user;

import com.chenyi.study.model.user.Role;
import com.chenyi.study.vo.RoleVO;
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

    List<RoleVO> findVOByUserId(@Param("userId") Long userId);
}