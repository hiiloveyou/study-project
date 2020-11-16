package com.chenyi.study.controller;

import com.chenyi.study.controller.bo.UserBO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/login")
public class AjaxLoginController {

    @GetMapping(value = "/loginPage")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/executeLogin")
    public String executeLogin() {
        final Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            return "login";
        }
        return "redirect:/test/hello";
    }

    @GetMapping(value = "/success")
    public String success(UserBO userBO, RedirectAttributes model) {
        //使用flash属性重定向，模型保存到会话中，重定向不丢失
        model.addFlashAttribute(userBO);
        return "redirect:/test/hello";
    }


}
