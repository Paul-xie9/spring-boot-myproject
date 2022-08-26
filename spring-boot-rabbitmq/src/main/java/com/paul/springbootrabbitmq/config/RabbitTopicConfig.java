package com.paul.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Paul.x
 * @Date 2022/8/23 22:37
 * @Description
 * */
@Configuration
public class RabbitTopicConfig {
    public final static String TOPICNAME = "spring-topic";
    @Bean
    Queue queueTopicOne(){
        return new Queue("one-topic-fanout");
    }
    @Bean
    Queue queueTopicTwo(){
        return new Queue("hello-queue-two-topic-fanout");
    }

    /**TopicExchange是比较复杂也比较灵活的一种路由策略，
     * 在TopicExchange中，Queue通过routingkey绑定到TopicExchange上，
     * 当消息到达TopicExchange后，TopicExchange根据消息的routingkey将消息路由到一个或者多个Queue上
     * @return
     */
    @Bean
    TopicExchange topicExchange(){
        //参数分别是名字、重启后是否依然有效以及长期未用时是否删除
        return new TopicExchange(TOPICNAME,true,false);
    }
    @Bean
    Binding bindingTopicOne(){
        //one.#”表示消息的routingkey凡是以“one”开头的，
        // 都将被路由到名称为“one”的Queue上
        return BindingBuilder.bind(queueTopicOne()).to(topicExchange())
                .with("one.#");
    }
    @Bean
    Binding bindingTopicTwo(){
        //Binding中的“#.two.#”则表示消息的routingkey中凡是包含“two”的，
        // 都将被路由到名称为“two”的Queue上
        return BindingBuilder.bind(queueTopicTwo()).to(topicExchange())
                .with("#.two.#");
    }
}