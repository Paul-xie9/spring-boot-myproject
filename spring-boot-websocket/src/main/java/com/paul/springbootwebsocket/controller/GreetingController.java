package com.paul.springbootwebsocket.controller;

import com.paul.springbootwebsocket.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Paul.x
 * @Date 2022/8/20 0:49
 * @Description
 */
@RestController
public class GreetingController {
    /**
     * @MessageMapping("/hello")注解的方法将用来接收“/app/hello”路径发送来的消息，
     * 在注解方法中对消息进行处理后，再将消息转发到@SendTo定义的路径上，而@SendTo路径是一个前缀为“/topic”的路径，
     * 因此该消息将被交给消息代理broker，再由broker进行广播。
     * @param message
     * @return
     */
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message){
        StringBuffer buffer = new StringBuffer();
        buffer.append(message.getContent());
        buffer.append(" + [经过处理的消息]");
        message.setContent(buffer.toString());
        return message;
    }
}
