package com.paul.springbootrabbitmq;

import com.paul.springbootrabbitmq.config.RabbitFanoutConfig;
import com.paul.springbootrabbitmq.config.RabbitHeaderConfig;
import com.paul.springbootrabbitmq.config.RabbitTopicConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;

@SpringBootTest
class SpringBootRabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    void directTest() {
        rabbitTemplate.convertAndSend("hello-queue","hello  direct!");
    }

    @Test
    void fanoutTest(){
        rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUTNAME,null,"hello  fanout!");
    }

    @Test
    void topicTest(){
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"one.news","hello  topic!");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"test.two.test","hello  topic!");
    }

    @Test
    void headerTest(){
        Message oneMsg = MessageBuilder.withBody("hello header! name-one".getBytes(StandardCharsets.UTF_8))
                .setHeader("name", "paul").build();
        Message twoMsg = MessageBuilder.withBody("hello header! name-two".getBytes(StandardCharsets.UTF_8))
                .setHeader("name", "xiebaocheng").build();
        rabbitTemplate.convertAndSend(RabbitHeaderConfig.HEADERNAME,null,oneMsg);
        rabbitTemplate.convertAndSend(RabbitHeaderConfig.HEADERNAME,null,twoMsg);
    }
}
