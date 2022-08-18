package com.paul.minhr.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Objects;

/**
 * @Author Paul.x
 * @Date 2022/8/17 17:46
 * @Description
 */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.paul.minhr.mapper.daoone"
//,entityManagerFactoryRef = "entityManagerFactoryBeanOne"
//,transactionManagerRef = "platformTransactionManagerOne")
public class JpaConfigOne {
//    @Autowired
//    @Qualifier("dsOne")
//    DataSource dsOne;
//    @Resource
//    JpaProperties jpaProperties;
//    @Bean
//    @Primary
//    LocalContainerEntityManagerFactoryBean entityManagerFactoryBeanOne(EntityManagerFactoryBuilder builder){
//        return builder.dataSource(dsOne)
//                .properties(jpaProperties.getProperties())
//                .packages("com.paul.minhr.model")
//                .persistenceUnit("pu1")
//                .build();
//    }
//
//    @Bean
//    PlatformTransactionManager platformTransactionManagerOne(EntityManagerFactoryBuilder builder){
//        LocalContainerEntityManagerFactoryBean factoryBeanOne = entityManagerFactoryBeanOne(builder);
//        return new JpaTransactionManager(Objects.requireNonNull(factoryBeanOne.getObject()));
//    }
}