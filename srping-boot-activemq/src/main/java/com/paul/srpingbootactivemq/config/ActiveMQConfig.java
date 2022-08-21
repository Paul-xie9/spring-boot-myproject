package com.paul.srpingbootactivemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @Author Paul.x
 * @Date 2022/8/21 19:35
 * @Description
 */
@Configuration
public class ActiveMQConfig {

    /**
     * 提供一个消息队列Bean
     * @return
     */
    @Bean
    Queue queue(){
        return new ActiveMQQueue("amq");
    }
}
