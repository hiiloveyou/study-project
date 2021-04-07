package com.chenyi.study.service.user;

import com.chenyi.study.rpc.api.user.PermissionService;
import com.chenyi.study.rpc.api.vo.SysPermissionVo;
import com.chenyi.study.ucenter.mapper.user.PermissionMapper;
import com.chenyi.study.ucenter.model.user.Permission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyi
 * @date 2020/11/14
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Permission record) {
        return permissionMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Permission record) {
        return permissionMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Permission record) {
        return permissionMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Permission record) {
        return permissionMapper.insertSelective(record);
    }

    @Override
    public Permission selectByPrimaryKey(Long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public Permission insertAndSelectByPrimaryKey(Permission record) {
        final int insert = permissionMapper.insert(record);
        return permissionMapper.selectByPrimaryKey((long) insert);
    }

    @Override
    public int updateByPrimaryKeySelective(Permission record) {
        return permissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return permissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Permission> list) {
        return permissionMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Permission> list) {
        return permissionMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Permission> list) {
        return permissionMapper.batchInsert(list);
    }

    @Override
    public List<SysPermissionVo> findAll() {
//        final List<PermissionVO> permissionVOList = permissionMapper.findAll();
        List<SysPermissionVo> listVo = new ArrayList<>();

        SysPermissionVo root = new SysPermissionVo();
        root.setId(0);
        root.setParent("#");
        root.setText("资源根节点");
        root.setState(true);
        listVo.add(root);
//        for (PermissionVO permissionVO : permissionVOList) {
//            SysPermissionVo VO = new SysPermissionVo();
//            VO.setId(permissionVO.getId().intValue());
//            VO.setParent(permissionVO.getParentId() + "");
//            VO.setText(permissionVO.getPermissionName());
//            VO.setState(true);
//            listVo.add(VO);
//        }
        return listVo;
    }
}

