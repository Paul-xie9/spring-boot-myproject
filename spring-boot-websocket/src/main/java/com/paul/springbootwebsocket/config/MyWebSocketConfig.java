package com.paul.springbootwebsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Author Paul.x
 * @Date 2022/8/20 0:42
 * @Description
 * @EnableWebSocketMessageBroker注解开启WebSocket消息代理
 */
@Configuration
@EnableWebSocketMessageBroker
public class MyWebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //表示定义一个前缀为“/chat”的endPoint，并开启sockjs支持，
        // sockjs可以解决浏览器对WebSocket的兼容性问题，客户端将通过这里配置的URL来建立WebSocket连接
        registry.addEndpoint("/chat").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //设置消息代理的前缀，即如果消息的前缀是“/topic”，就会将消息转发给消息代理（broker）
        // 再由消息代理将消息广播给当前连接的客户端
        registry.enableSimpleBroker("/topic");
        //配置一个或多个前缀，通过这些前缀过滤出需要被注解方法处理的消息，其余的交给broker处理.例如"/topic"
        registry.setApplicationDestinationPrefixes("/app");
    }
}
