package com.paul.minhr.config.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Author Paul.x
 * @Date 2022/8/17 3:42
 * @Description
 */
@Configuration
public class JdbcTemplateConfig {
    /**
     * [@Qualifier]注解表示查找不同名称的DataSource实例注入进来
     * @param dataSource
     * @return
     */
    @Bean
    JdbcTemplate jdbcTemplateOne(@Qualifier("dsOne") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean
    JdbcTemplate jdbcTemplateTwo(@Qualifier("dsTwo") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
