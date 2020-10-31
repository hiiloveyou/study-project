package com.chenyi.study.mapper.user;

import com.chenyi.study.model.user.UserGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserGroupMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(UserGroup record);

    int insertOrUpdate(UserGroup record);

    int insertOrUpdateSelective(UserGroup record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserGroup record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    UserGroup selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserGroup record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserGroup record);

    int updateBatch(List<UserGroup> list);

    int updateBatchSelective(List<UserGroup> list);

    int batchInsert(@Param("list") List<UserGroup> list);
}