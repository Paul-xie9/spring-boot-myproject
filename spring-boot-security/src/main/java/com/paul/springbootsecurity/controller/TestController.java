package com.paul.springbootsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Paul.x
 * @Date 2022/8/19 6:32
 * @Description
 */
@RestController
public class TestController {

    @RequestMapping("/admin/test")
    public String testAdmin(){
        return "/admin/test";
    }
    @RequestMapping("/user/test")
    public String testUser(){
        return "/user/test";
    }
}
