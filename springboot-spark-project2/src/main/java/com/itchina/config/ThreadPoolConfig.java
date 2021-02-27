package com.itchina.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池
 * */
@Configuration
@EnableAsync
public class ThreadPoolConfig {
    @Bean
    public Executor asyncServiceExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        /** 配置核心线程数 */
        executor.setCorePoolSize(8);
        /** 配置最大线程数 */
        executor.setMaxPoolSize(20);
        /** 配置队列大小 */
        executor.setQueueCapacity(800);
        /** 线程的名称前缀 */
        executor.setThreadNamePrefix("threadpool-tydic-");
        /** 策略：超过线程池负荷，主线程也参与工作 */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
