package com.itchina.pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @Date: 2021/4/27 17:36
 * @Desc:  submit(new Runnable)
 */
public class ThreadPool2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService taskExecutor = Executors.newFixedThreadPool(2);
        Future<?> submit = taskExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("=====");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(submit.isDone());
        System.out.println(submit.get());//阻塞的，等待run方法结束返回
        taskExecutor.shutdown();
    }

}
