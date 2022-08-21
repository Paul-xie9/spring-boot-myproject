package com.paul.srpingbootactivemq;

import com.paul.srpingbootactivemq.config.JmsComponent;
import com.paul.srpingbootactivemq.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SrpingBootActivemqApplicationTests {
    @Autowired
    JmsComponent jmsComponent;
    @Test
    void contextLoads() {
        Message message = new Message();
        message.setName("acitvemq");
        message.setContent("hello activemq jms");
        message.setDate(new Date());
        jmsComponent.send(message);
    }
}
