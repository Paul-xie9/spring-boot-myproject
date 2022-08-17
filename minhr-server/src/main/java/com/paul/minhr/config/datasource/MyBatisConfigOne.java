package com.paul.minhr.config.datasource;

//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author Paul.x
 * @Date 2022/8/17 16:40
 * @Description
 * 在@MapperScan注解中指定Mapper接口所在的位置，
 * 同时指定SqlSessionFactory的实例名，则该位置下的Mapper将使用SqlSessionFactory实例
 */
@Configuration
//@MapperScan(value = "com.paul.minhr.mapper.mapperOne",sqlSessionFactoryRef = "sqlSessionFactoryOne")
public class MyBatisConfigOne {
//    @Autowired
//    @Qualifier("dsOne")
//    DataSource dsOne;
//    @Bean
//    SqlSessionFactory sqlSessionFactoryOne() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dsOne);
//        return factoryBean.getObject();
//    }
//    @Bean
//    SqlSessionTemplate sqlSessionTemplateOne() throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactoryOne());
//    }
}
