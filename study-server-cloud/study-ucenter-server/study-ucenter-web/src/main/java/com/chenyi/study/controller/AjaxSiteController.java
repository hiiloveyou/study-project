//package com.chenyi.study.controller;
//
//
//import com.chenyi.study.rpc.api.user.UserService;
//import com.chenyi.study.ucenter.model.user.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.UUID;
//
//@RestController
//@RequestMapping(value = "/test")
//public class AjaxSiteController {
//    @Autowired
//    private UserService userService;
//
////    @RequiresPermissions("USER:LIST")
//    @RequestMapping("/hello")
//    public String index(UserBO userBO, Model model) {
//        ArrayList<Article> list = new ArrayList<>();
//        list.add(new Article("Async：简洁优雅的异步之道", "在异步处理方案中，目前最为简洁优雅的便是async函数（以下简称A函数）。", "www.baidu.com"));
//        list.add(new Article("H5 前端性能测试实践", "H5 页面发版灵活，轻量，又具有跨平台的特性，在业务上有很多应用场景。", "www.baidu.com"));
//        list.add(new Article("学习Python的建议", "Python是最容易入门的编程语言。", "www.baidu.com"));
//        model.addAttribute("articleList", list);
//        return "/main/resources/templates/backup/login.html";
//    }
//
//
//    @RequestMapping("/view")
//    public String view(Model model) {
//        model.addAttribute("exception", "list");
//        return "/base/error";
//    }
//
//    @PostMapping(value = "/transaction")
//    public void testTransaction(@RequestBody @Valid UserBO userBO) {
//        User user = new User();
//        user.setUserName(userBO.getUserName());
//        user.setTelephone(userBO.getTelephone());
//        user.setLoginName(userBO.getLoginName());
//        user.setEmailAddress(userBO.getEmailAddress());
//        user.setUserType(userBO.getUserType());
//        user.setPassword(userBO.getPassword());
//        user.setSalt(UUID.randomUUID().toString());
//        user.setStatus(1);
//        user.setDescription(userBO.getDescription());
//        userService.insert(user);
//    }
//}
