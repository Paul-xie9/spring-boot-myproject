package com.paul.springbootquartz.config;

import com.paul.springbootquartz.job.MySecondJob;
import org.quartz.JobDataMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

import java.util.Objects;

/**
 * @Author Paul.x
 * @Date 2022/8/21 22:10
 * @Description
 */
@Configuration
public class MyQuartzConfig {

    /**
     * JobDetail的配置有两种方式：
     * 第一种方式通过MethodInvokingJobDetailFactoryBean类配置JobDetail，
     * 只需要指定Job的实例名和要调用的方法即可，注册这种方式无法在创建JobDetail时传递参数
     *
     * 第二种方式是通过JobDetailFactoryBean来实现的，这种方式只需要指定JobClass即可，
     * 然后可以通过JobDataMap传递参数到Job中，Job中只需要提供属性名，并且提供一个相应的set方法即可接收到参数。
     * @return
     */
    @Bean
    MethodInvokingJobDetailFactoryBean jobDetailFactoryBean(){
        MethodInvokingJobDetailFactoryBean factoryBean = new MethodInvokingJobDetailFactoryBean();
        factoryBean.setTargetBeanName("myFirstJob");
        factoryBean.setTargetMethod("sayHello");
        return factoryBean;
    }
    @Bean
    JobDetailFactoryBean detailFactoryBean(){
        JobDetailFactoryBean detailFactoryBean = new JobDetailFactoryBean();
        detailFactoryBean.setJobClass(MySecondJob.class);
        JobDataMap dataMap = new JobDataMap();
        dataMap.put("name","paul");
        detailFactoryBean.setJobDataMap(dataMap);
        detailFactoryBean.setDurability(true);
        return detailFactoryBean;
    }

    /**
     * Trigger有多种不同实现，两种常用的Trigger：
     * SimpleTrigger和CronTrigger，这两种Trigger分别使用SimpleTriggerFactoryBean和CronTriggerFactoryBean进行创建。
     * 在SimpleTriggerFactoryBean对象中，首先设置JobDetail，然后通过setRepeatCount配置任务循环次数，
     * setStartDelay配置任务启动延迟时间，setRepeatInterval配置任务的时间间隔。
     * 在CronTriggerFactoryBean对象中，则主要配置JobDetail和Cron表达式。
     * @return
     */
    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean(){
        SimpleTriggerFactoryBean triggerFactoryBean = new SimpleTriggerFactoryBean();
        triggerFactoryBean.setJobDetail(Objects.requireNonNull(jobDetailFactoryBean().getObject()));
        triggerFactoryBean.setRepeatCount(3);
        triggerFactoryBean.setStartDelay(1000);
        triggerFactoryBean.setRepeatInterval(2000);
        return triggerFactoryBean;
    }
    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean(){
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(Objects.requireNonNull(detailFactoryBean().getObject()));
        cronTriggerFactoryBean.setCronExpression("* * * * * ?");
        return cronTriggerFactoryBean;
    }

    /**
     * 最后通过SchedulerFactoryBean创建SchedulerFactory，然后配置Trigger即可
     * @return
     */
    @Bean
    SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerBean = new SchedulerFactoryBean();
        schedulerBean.setTriggers(simpleTriggerFactoryBean().getObject(), cronTriggerFactoryBean().getObject());
        return schedulerBean;
    }
}
