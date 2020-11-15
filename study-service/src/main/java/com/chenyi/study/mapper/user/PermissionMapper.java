package com.chenyi.study.mapper.user;

import com.chenyi.study.model.user.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenyi
 * @date 2020/11/14
 */
public interface PermissionMapper {
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
    int insert(Permission record);

    int insertOrUpdate(Permission record);

    int insertOrUpdateSelective(Permission record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Permission record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Permission selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Permission record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Permission record);

    int updateBatch(List<Permission> list);

    int updateBatchSelective(List<Permission> list);

    int batchInsert(@Param("list") List<Permission> list);
}