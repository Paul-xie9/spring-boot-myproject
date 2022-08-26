package com.paul.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Paul.x
 * @Date 2022/8/23 22:08
 * @Description
 */
@Configuration
public class RabbitFanoutConfig {
    public final static String FANOUTNAME = "spring-fanout";
    @Bean
    Queue queueOne(){
        return new Queue("hello-queue-one-fanout");
    }
    @Bean
    Queue queueTwo(){
        return new Queue("hello-queue-two-fanout");
    }

    /**
     * FanoutExchange的数据交换策略是把所有到达FanoutExchange的消息转发给所有与它绑定的Queue，
     * 在这种策略中，routingkey将不起任何作用
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange(){
        //参数分别是名字、重启后是否依然有效以及长期未用时是否删除
        return new FanoutExchange(FANOUTNAME,true,false);
    }
    @Bean
    Binding bindingOne(){
        return BindingBuilder.bind(queueOne()).to(fanoutExchange());
    }
    @Bean
    Binding bindingTwo(){
        return BindingBuilder.bind(queueTwo()).to(fanoutExchange());
    }
}
