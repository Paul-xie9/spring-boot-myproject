package com.paul.springbootcrossorigin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author Paul.x
 * @Date 2022/8/18 22:42
 * @Description
 */
@RestController
public class TestController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/saveName")
    public String saveName(String name, HttpSession session){
        session.setAttribute("name",name);
        return port;
    }

    @RequestMapping("/getName")
    public String getName(HttpSession session){
        return port+":"+session.getAttribute("name").toString();
    }
}
