package com.paul.springbootbatch.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.job.JobStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Paul.x
 * @Date 2022/8/21 23:56
 * @Description
 */
@Log4j2
@Configuration
public class MyBatchJobConfig {
    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @StepScope
    String myStepScope(){
        log.info("========myStepScope()==========");
        return "myStepScope";
    }

    @Bean
    Step myStep(){
        return stepBuilderFactory.get("myStep")
                .chunk(2)
                .processor(new ItemProcessor<Object, Object>() {
                    @Override
                    public Object process(Object o) throws Exception {
                        log.info("========myStepScope()==========");
                        return null;
                    }
                })
                .build();
    }

    @Bean
    Job myJob(){
        return jobBuilderFactory.get("myFirstJob")
                .start(myStep()).build();
    }
}
