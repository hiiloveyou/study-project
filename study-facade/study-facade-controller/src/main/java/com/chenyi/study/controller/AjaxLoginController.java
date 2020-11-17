package com.chenyi.study.controller;

import com.chenyi.study.controller.bo.UserBO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AjaxLoginController {

    @RequestMapping({"/", "/index"})
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        final Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "index";
        }
        return "login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        return "403";
    }

    @GetMapping(value = "/success")
    public String success(UserBO userBO, RedirectAttributes model) {
        //使用flash属性重定向，模型保存到会话中，重定向不丢失
        model.addFlashAttribute(userBO);
        return "redirect:/test/hello";
    }

}
