package com.itchina.job;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2021/2/27 22:51
 * @Desc:
 */
@Configuration
public class MyQuartzJobConfig {

    @Bean
    public JobDetail jobDetail(){
        JobDetail detail = JobBuilder.newJob(MyQuartzJob.class)
                .withIdentity("job1", "group1")
                .storeDurably().build();
        return detail;
    }

    /** 触发器 */
    //@Bean
    public Trigger trigger(){
        CronTrigger trigger = TriggerBuilder.newTrigger().forJob(jobDetail())
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0,5 * * * * ?")).build();
        return trigger;
    }

}
