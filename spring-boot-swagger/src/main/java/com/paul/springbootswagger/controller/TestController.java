package com.paul.springbootswagger.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Paul.x
 * @Date 2022/8/22 2:03
 * @Description
 */
@RestController
@Api(tags = "测试数据接口")
public class TestController {
    @RequestMapping("/getAll")
    public String getAll(){
        return "getAll()";
    }
}
