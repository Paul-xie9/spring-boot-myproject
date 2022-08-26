package com.paul.springbootrabbitmq.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author Paul.x
 * @Date 2022/8/23 20:41
 * @Description 消费者
 */
@Log4j2
@Component
public class DirectReceiver {
    /**
     * @RabbitListener
     * 注解指定一个方法是一个消息消费方法
     * @param msg
     */
    @RabbitListener(queues = {"hello-queue"})
    public void handler(String msg){
        log.info("=============DirectReceiver => "+msg);
    }
}
