//package com.chenyi.study.controller;
//
//import com.chenyi.study.constant.StateParameter;
//import com.chenyi.study.model.user.Permission;
//import com.chenyi.study.service.user.PermissionService;
//import com.chenyi.study.vo.SysPermissionVo;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import net.sf.json.JsonConfig;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
//
//@Controller
//@RequestMapping("/sysPermission")
//public class SysPermissionController extends BaseController {
//    @Autowired
//    private PermissionService permissionService;
//
//    /**
//     * 资源查询.
//     *
//     * @return
//     */
//    @RequestMapping("/permissionView")
//    @RequiresPermissions("sysPermission:view")//权限管理;
//    public String view() {
//        logger.info("加载permission....");
//        return "/base/permission";
//    }
//
//
//    /**
//     * 查询所有资源
//     *
//     * @return
//     */
//    @RequestMapping("/findAll")
//    //@RequiresPermissions("userInfo:add")//权限管理;
//    @ResponseBody
//    public JSONArray findAll() {
//
//        List<SysPermissionVo> listVo = permissionService.findAll();
//
//        if (listVo.size() > 0) {
//            return JSONArray.fromObject(listVo);
//        } else {
//            return new JSONArray();
//        }
//
//    }
//
//
//    /**
//     * 资源添加;
//     *
//     * @return
//     */
//    @RequestMapping("/sysPermissionAdd")
//    //@RequiresPermissions("userInfo:add")//权限管理;
//    @ResponseBody
//    public ModelMap sysPermissionAdd(Permission permission) {
//        logger.info("添加资源：" + permission.getPermissionName());
//        logger.info("添加资源parentId：" + permission.getParentId());
//        Permission result = null;
//        result = permissionService.insertAndSelectByPrimaryKey(permission);
//        if (result != null) {
//            return getModelMap(StateParameter.SUCCESS, result, "添加资源成功");
//        } else {
//            return getModelMap(StateParameter.FAULT, null, "添加资源失败");
//        }
//
//    }
//
//
//    /**
//     * 用户更新
//     *
//     * @return
//     */
//    @RequestMapping("/updatePermission")
//    //@RequiresPermissions("userInfo:add")//权限管理;
//    @ResponseBody
//    public ModelMap updatePermission(Permission permission) {
//        logger.info("更新资源：" + permission.getPermissionName());
//
//        int result = permissionService.updateByPrimaryKey(permission);
//        if (result > 0) {
//            return getModelMap(StateParameter.SUCCESS, result, "更新资源成功");
//        } else {
//            return getModelMap(StateParameter.FAULT, null, "更新资源失败");
//        }
//
//    }
//
//
//    /**
//     * 通过uid查询资源信息
//     *
//     * @return
//     */
//    @RequestMapping("/findByOne")
//    @ResponseBody
//    public ModelMap findByOne(String id) {
//        logger.info("查询资源信息：" + id);
//        Permission result = permissionService.selectByPrimaryKey(Long.valueOf(id));
//        if (result != null) {
//            JsonConfig config = new JsonConfig();
//            config.setExcludes(new String[]{"roles"});
//            JSONObject json = JSONObject.fromObject(result, config);
//            return getModelMap(StateParameter.SUCCESS, json, "操作成功");
//        } else {
//            return getModelMap(StateParameter.FAULT, null, "操作失败");
//        }
//    }
//
//
//    /**
//     * 通过uid删除资源信息
//     *
//     * @return
//     */
//    @RequestMapping("/delete")
//    @ResponseBody
//    public ModelMap delete(String id) {
//        logger.info("删除资源信息：" + id);
//        try {
//            permissionService.deleteByPrimaryKey(Long.valueOf(id));
//            return getModelMap(StateParameter.SUCCESS, null, "操作成功");
//        } catch (Exception e) {
//            return getModelMap(StateParameter.FAULT, null, "操作失败");
//        }
//    }
//}