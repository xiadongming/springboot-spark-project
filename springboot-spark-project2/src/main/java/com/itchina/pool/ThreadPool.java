package com.itchina.pool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Date: 2021/4/12 15:41
 * @Desc:
 */
public class ThreadPool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        ExecutorService executorService1 = Executors.newCachedThreadPool();

        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.initialize();


        threadPoolTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

}
