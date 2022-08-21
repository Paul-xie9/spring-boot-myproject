package com.paul.srpingbootactivemq.config;

import com.paul.srpingbootactivemq.model.Message;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @Author Paul.x
 * @Date 2022/8/21 19:41
 * @Description
 */
@Log4j2
@Component
public class JmsComponent {

    /**
     * JmsMessagingTemplate是由Spring提供的一个JMS消息发送模板，
     * 可以用来方便地进行消息的发送
     */
    @Autowired(required = false)
    JmsMessagingTemplate messagingTemplate;
    @Autowired(required = false)
    Queue queue;
    public void send(Message message){
        //方法convertAndSend的第一个参数是消息队列，第二个参数是消息内容
        messagingTemplate.convertAndSend(this.queue,message);
    }

    /**
     * @JmsListener注解则表示相应的方法是一个消息消费者，
     * 消息消费者订阅的消息destination为amq
     * @param message
     */
    @JmsListener(destination = "amq")
    public void receive(Message message){
       log.info("Jms receive message=>"+message);
    }
}
