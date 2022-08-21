package com.paul.springbootbatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 11098
 * @EnableBatchProcessing 开启Spring Batch支持
 */
@SpringBootApplication
@EnableBatchProcessing
public class SpringBootBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBatchApplication.class, args);
    }

}
