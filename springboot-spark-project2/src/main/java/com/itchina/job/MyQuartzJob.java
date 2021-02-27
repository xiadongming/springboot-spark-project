package com.itchina.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Date: 2021/2/27 22:41
 * @Desc: 需要执行的任务
 */
public class MyQuartzJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartzJod= " + System.currentTimeMillis());
    }
}
