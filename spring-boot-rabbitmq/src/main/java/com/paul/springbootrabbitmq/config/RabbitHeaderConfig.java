package com.paul.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @Author Paul.x
 * @Date 2022/8/26 20:44
 * @Description
 */
@Configuration
public class RabbitHeaderConfig {
    public final static String HEADERNAME = "spring-header";
    @Bean
    Queue queueHeaderOne(){
        return new Queue("hello-queue-one-header");
    }
    @Bean
    Queue queueHeaderTwo(){
        return new Queue("hello-queue-two-header");
    }

    /**
     * HeadersExchange会根据消息的Header
     * 将消息路由到不同的Queue上，这种策略也和routingkey无关
     * @return
     */
    @Bean
    HeadersExchange headersExchange(){
        //参数分别是名字、重启后是否依然有效以及长期未用时是否删除
        return new HeadersExchange(HEADERNAME,true,false);
    }
    @Bean
    Binding bindingHeaderOne(){
        return BindingBuilder.bind(queueHeaderOne()).to(headersExchange())
                .where("one").exists();
    }
    @Bean
    Binding bindingHeaderTwo(){
        HashMap<String, Object> map = new HashMap<>(1);
        map.put("one","one header");
        return BindingBuilder.bind(queueHeaderTwo()).to(headersExchange())
                .whereAny(map).match();
    }
}
