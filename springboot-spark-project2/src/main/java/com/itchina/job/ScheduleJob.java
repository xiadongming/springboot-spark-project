package com.itchina.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Date: 2021/2/27 22:01
 * @Desc: 定时任务
 */
@Component
@EnableScheduling //或者加到启动类上
public class ScheduleJob {

     /** 放开即可 */
    //@Scheduled(fixedDelay = 3000)
    public void runnJob(){
        System.out.println("time= " + System.currentTimeMillis());
    }

}
