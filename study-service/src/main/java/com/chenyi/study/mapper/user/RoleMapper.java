package com.chenyi.study.mapper.user;

import com.chenyi.study.model.user.Role;
import com.chenyi.study.vo.RoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author BG344144
 */
public interface RoleMapper extends tk.mybatis.mapper.common.Mapper<Role> {
    int updateBatch(List<Role> list);

    int updateBatchSelective(List<Role> list);

    int batchInsert(@Param("list") List<Role> list);

    int insertOrUpdate(Role record);

    int insertOrUpdateSelective(Role record);

    List<RoleVO> findVOByUserId(@Param("userId") Long userId);
}