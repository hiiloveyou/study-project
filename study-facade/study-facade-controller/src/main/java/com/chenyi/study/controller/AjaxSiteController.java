package com.chenyi.study.controller;

import com.chenyi.study.controller.bo.UserBO;
import com.chenyi.study.model.Article;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/test")
public class AjaxSiteController {

    @RequiresPermissions("USER:LIST")
    @RequestMapping("/hello")
    public String index(UserBO userBO, Model model) {
        ArrayList<Article> list = new ArrayList<>();
        list.add(new Article("Async：简洁优雅的异步之道", "在异步处理方案中，目前最为简洁优雅的便是async函数（以下简称A函数）。", "www.baidu.com"));
        list.add(new Article("H5 前端性能测试实践", "H5 页面发版灵活，轻量，又具有跨平台的特性，在业务上有很多应用场景。", "www.baidu.com"));
        list.add(new Article("学习Python的建议", "Python是最容易入门的编程语言。", "www.baidu.com"));
        model.addAttribute("articleList", list);
        return "/main/resources/templates/backup/login.html";
    }


    @RequestMapping("/view")
    public String view(Model model) {
        model.addAttribute("exception", "list");
        return "error";
    }

}
