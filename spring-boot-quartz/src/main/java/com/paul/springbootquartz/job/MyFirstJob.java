package com.paul.springbootquartz.job;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author Paul.x
 * @Date 2022/8/21 22:01
 * @Description
 * 一个普通的JavaBea
 */
@Log4j2
@Component
public class MyFirstJob {
    public void sayHello(){
        log.info("=============MyFirstJob.sayHello()==="+new Date() +"=================");
    }
}
