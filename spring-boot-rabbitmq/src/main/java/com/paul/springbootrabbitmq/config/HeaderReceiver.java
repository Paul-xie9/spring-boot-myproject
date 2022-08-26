package com.paul.springbootrabbitmq.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author Paul.x
 * @Date 2022/8/26 22:37
 * @Description
 */
@Log4j2
@Component
public class HeaderReceiver {
    /**
     * @RabbitListener注解指定一个方法是一个消息消费方法
     * @param msg
     */
    @RabbitListener(queues = {"hello-queue-one-header"})
    public void handlerHeaderOne(byte[] msg){
        log.info("=============HeaderReceiver.handlerHeaderOne() => "+msg);
    }

    @RabbitListener(queues = {"hello-queue-two-header"})
    public void handlerHeaderTwo(byte[] msg){
        log.info("=============HeaderReceiver.handlerHeaderTwo() => "+msg);
    }
}
