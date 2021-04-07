//package com.chenyi.study.controller;
//
//import com.chenyi.study.constant.StateParameter;
//import com.chenyi.study.vo.PermissionVO;
//import com.chenyi.study.vo.RoleVO;
//import com.chenyi.study.vo.UserVO;
//import net.sf.json.JSONArray;
//import net.sf.json.JsonConfig;
//import org.apache.shiro.SecurityUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.ui.ModelMap;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.UUID;
//
//public abstract class BaseController {
//
//    protected final String success = StateParameter.SUCCESS;
//    protected final String fail = StateParameter.FAULT;
//
//    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    public ModelMap getModelMap(String status, java.io.Serializable data, String msg) {
//        ModelMap modelMap = new ModelMap();
//        modelMap.put("status", status);
//        modelMap.put("data", data);
//        modelMap.put("msg", msg);
//        return modelMap;
//
//    }
//
//    public String getUuid() {
//        String uuid = UUID.randomUUID().toString(); //获取UUID并转化为String对象
//        uuid = uuid.replace("-", "");
//        return uuid;
//    }
//
//    /**
//     * 获取当前登录的用户角色
//     */
//    public UserVO getCurrentUser() {
//        return (UserVO) SecurityUtils.getSubject().getPrincipal();
//    }
//
//    public JSONArray getCurrentUserPermission(UserVO userVO) {
//
//        List<PermissionVO> permissionVOList = new ArrayList<>();
//        List<RoleVO> roleVOList = userVO.getRoleVOList();
//        for (RoleVO roleVO : roleVOList) {
//            permissionVOList.addAll(roleVO.getPermissionVOList());
//        }
//        System.out.println("------处理资源树前--------------:" + permissionVOList.size());
//        List<PermissionVO> newAllList = new ArrayList<>();
//        for (PermissionVO permissionVO : permissionVOList) {
//
////            if (permissionVO.getAvailable()) {
////                //去除已经禁止的资源(不执行添加功能)
////                continue;
////            }
//            if (Objects.equals(permissionVO.getPermissionType(), "menu")) {
//                if (!newAllList.contains(permissionVO)) {
//                    newAllList.add(permissionVO);
//                }
//
//            } else {
//                if ("roleInfo/getAllData".equals(permissionVO.getUrl())) {
//                    SecurityUtils.getSubject().getSession().setAttribute("isSearchAllData", true);
//                }
//            }
//        }
//        System.out.println("------处理剩余结果后--------------" + newAllList.size());
//        //进行list对象某属性排序
////        SortList<PermissionVO> sortList = new SortList<PermissionVO>();
////        sortList.Sort(newAllList, "getNumberSort");
//
//        JsonConfig config = new JsonConfig();
//        config.setExcludes(new String[]{"roles"});
//        return JSONArray.fromObject(newAllList, config);
//    }
//
//}
