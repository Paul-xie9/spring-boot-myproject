package com.paul.springbootquartz.job;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author Paul.x
 * @Date 2022/8/21 22:05
 * @Description
 */
@Log4j2
@Data
@Component
public class MySecondJob extends QuartzJobBean {
    private String name;

    /**
     * 该方法在任务被调用时使用
     * @param context
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
       log.info("=name=>=="+name+"=========MySecondJob.executeInternal()====="+new Date() +"=======");
    }
}
