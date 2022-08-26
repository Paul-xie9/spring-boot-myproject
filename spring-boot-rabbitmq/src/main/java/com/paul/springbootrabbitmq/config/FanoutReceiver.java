package com.paul.springbootrabbitmq.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author Paul.x
 * @Date 2022/8/23 22:14
 * @Description
 */
@Log4j2
@Component
public class FanoutReceiver {
    /**
     * @RabbitListener注解指定一个方法是一个消息消费方法
     * @param msg
     */
    @RabbitListener(queues = {"hello-queue-one-fanout"})
    public void handlerOne(String msg){
        log.info("=============FanoutReceiver.handlerOne() => "+msg);
    }

    @RabbitListener(queues = {"hello-queue-two-fanout"})
    public void handlerTwo(String msg){
        log.info("=============FanoutReceiver.handlerTwo() => "+msg);
    }
}
