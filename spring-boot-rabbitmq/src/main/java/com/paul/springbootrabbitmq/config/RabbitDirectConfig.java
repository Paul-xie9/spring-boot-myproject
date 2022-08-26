package com.paul.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Paul.x
 * @Date 2022/8/23 13:19
 * @Description
 */
@Configuration
public class RabbitDirectConfig {
    public final static String DIRECTNAME = "spring-direct";
    @Bean
    Queue queue(){
        return new Queue("hello-queue");
    }

    /**
     * DirectExchange的路由策略是将消息队列绑定到一个DirectExchange上，
     * 当一条消息到达DirectExchange时会被转发到与该条消息routing key相同的Queue上，
     * 例如消息队列名为“hello-queue”，则routingkey为“hello-queue”的消息会被该消息队列接收
     * @return
     */
    @Bean
    DirectExchange directExchange(){
        //参数分别是名字、重启后是否依然有效以及长期未用时是否删除
        return new DirectExchange(DIRECTNAME,true,false);
    }
    @Bean
    Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange())
                .with("direct");
    }
}
