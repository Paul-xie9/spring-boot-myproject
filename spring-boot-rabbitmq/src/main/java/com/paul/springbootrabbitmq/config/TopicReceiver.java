package com.paul.springbootrabbitmq.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author Paul.x
 * @Date 2022/8/24 23:20
 * @Description
 */
@Log4j2
@Component
public class TopicReceiver {
    @RabbitListener(queues = "one-topic-fanout")
    public void handlerOne(String msg){
       log.info("===========TopicReceiver.handlerOne()=>  "+msg);
    }

    @RabbitListener(queues = "hello-queue-two-topic-fanout")
    public void handlerTwo(String msg){
        log.info("===========TopicReceiver.handlerTwo()=>  "+msg);
    }
}
