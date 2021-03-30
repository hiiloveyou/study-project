//package com.chenyi.study.controller;
//
//import com.chenyi.study.bo.UserBO;
//import com.chenyi.study.toolkit.utils.Captcha;
//import com.chenyi.study.toolkit.utils.GifCaptcha;
//import com.chenyi.study.vo.UserVO;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.Subject;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@Slf4j
//@Controller
//@RequestMapping(value = "/login")
//public class AjaxLoginController {
//
//    @RequestMapping("")
//    public String index(){
//        log.info("初始化登录页面....");
//        return"/base/login";
//
//    }
//
//    @RequestMapping(value = "/loginUser")
//    public String login(HttpServletRequest request) {
//        final HttpSession session = request.getSession();
//        final Subject subject = SecurityUtils.getSubject();
//        final Session subjectSession = subject.getSession();
//        if (subject.isAuthenticated()) {
//            final UserVO userVO = (UserVO) subject.getPrincipal();
//            session.setAttribute("user", userVO);
//            session.setAttribute("clickId", "home");
//            subjectSession.setAttribute("user", userVO);
//            subjectSession.setAttribute("clickId", "home");
//            return "/base/loadHome";
//        }
//        request.setAttribute("message", "用户名或密码不正确");
//        return "/base/login";
//    }
//
//    /**
//     * 获取验证码（Gif版本）
//     *
//     * @param response
//     */
//    @RequestMapping(value = "/getGifCode", method = RequestMethod.GET)
//    public void getGifCode(HttpServletResponse response, HttpServletRequest request) {
//        try {
//            response.setHeader("Pragma", "No-cache");
//            response.setHeader("Cache-Control", "no-cache");
//            response.setDateHeader("Expires", 0);
//            response.setContentType("image/gif");
//            /**
//             * gif格式动画验证码
//             * 宽，高，位数。
//             */
//            HttpSession session = request.getSession(true);
//
//            Captcha captcha = new GifCaptcha(146, 33, 4);
//            /* 输出 */
//            captcha.out(response.getOutputStream());
//            String vcodeText = captcha.text().toLowerCase();
//            //存入Session
//            session.setAttribute("_code", vcodeText);
//            log.info("保存vcode:" + vcodeText);
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("获取验证码异常：{}", e.getMessage(), e);
//        }
//    }
//
//    @RequestMapping(value = "/logout")
//    public String logout(HttpSession session) {
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
//        session.removeAttribute("user");
//        return "/base/login";
//    }
//
//    @RequestMapping("/403")
//    public String unauthorizedRole() {
//        return "/base/error";
//    }
//
//    @GetMapping(value = "/success")
//    public String success(UserBO userBO, RedirectAttributes model) {
//        //使用flash属性重定向，模型保存到会话中，重定向不丢失
//        model.addFlashAttribute(userBO);
//        return "redirect:/test/hello";
//    }
//
//}
