package com.paul.springbootshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author Paul.x
 * @Date 2022/8/19 18:54
 * @Description
 */
@RestController
public class TestController {
    @PostMapping("/doLogin")
    public ModelAndView doLogin(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        ModelAndView modelAndView = new ModelAndView();
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (Exception e) {
            modelAndView.addObject("error", "用户名或者密码错误");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/index");
        return modelAndView;
    }
    /**
     * 需要具有admin角色才可以访问
     * @return
     */
    @RequiresRoles("admin")
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
    /**
     * 具备admin角色和user角色其中任意一个即可访问
     * @return
     */
    @RequiresRoles(value = {"admin","user"},logical = Logical.OR)
    @RequestMapping("/user")
    public String user(){
        return "user";
    }
}
