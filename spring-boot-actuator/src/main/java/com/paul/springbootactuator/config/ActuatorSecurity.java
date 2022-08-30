package com.paul.springbootactuator.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author Paul.x
 * @Date 2022/8/26 23:16
 * @Description
 */
@Configuration
public class ActuatorSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //在HttpSecurity中配置所有的Endpoint都需要具有ADMIN角色才能访问，同时开启HttpBasic认证
        //EndpointRequest.toAnyEndpoint()表示匹配所有的Endpoint，例如shutdown、mappings、health等，
        // 但是不包括开发者通过@RequestMapping注解定义的接口
        http.requestMatcher(EndpointRequest.toAnyEndpoint())
                .authorizeRequests().anyRequest()
                .hasRole("admin").and().httpBasic();
    }
}
