package com.paul.springbootshiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Paul.x
 * @Date 2022/8/19 18:43
 * @Description
 */
@Configuration
public class MyShiroConfig {
    @Bean
    public Realm realm(){
        TextConfigurationRealm realm = new TextConfigurationRealm();
        //用户paul 角色user; 用户admin 角色admin
        realm.setUserDefinitions("paul=root,user\n admin=root,admin");
        //admin角色拥有read,write权限; user角色拥有read权限
        realm.setRoleDefinitions("admin=read,write\n user=read");
        return realm;
    }

    /**
     * 配置基本的过滤规则
     * @return
     */
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        //“/login”和“/doLogin”可以匿名访问
        definition.addPathDefinition("/login","anon");
        definition.addPathDefinition("/doLogin","anon");
        //“/logout”是一个注销登录请求
        definition.addPathDefinition("/logout","logout");
        //其余请求则都需要认证后才能访问
        definition.addPathDefinition("/**","authc");
        return definition;
    }

    /**
     * 为了支持在Thymeleaf中使用Shiro标签
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
