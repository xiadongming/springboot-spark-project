package com.itchina.pool;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Date: 2021/4/28 10:03
 * @Desc: submit(new Callable)
 * 正确的
 */
public class ThreadPool4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService taskExecutor = Executors.newFixedThreadPool(20);

        /**
         * 假设有100个任务需要交给线程池处理
         * */
        List<Future> futureList = new ArrayList<>();
        Future<Object> future = null;
        for (int i = 0; i < 100; i++) {
            future = taskExecutor.submit(new CallableServiceImpl());
            futureList.add(future);
        }

        if (!CollectionUtils.isEmpty(futureList)) {
            for (Future future1 : futureList) {
                Object o = future1.get();
                System.out.println("result= " + String.valueOf(o) + ",threadName= " + Thread.currentThread().getName());
            }
        }
        taskExecutor.shutdown();

    }
}
