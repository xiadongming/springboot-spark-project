package com.itchina.pool;

import org.codehaus.groovy.runtime.dgmimpl.arrays.ShortArrayPutAtMetaMethod;

import java.util.concurrent.*;

/**
 * @Date: 2021/4/27 17:42
 * @Desc:  submit(new Callable)
 */
public class ThreadPool3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService taskExecutor = Executors.newFixedThreadPool(2);

        Future<Object> submit = taskExecutor.submit(new CallableServiceImpl());


        System.out.println(submit.get());
        System.out.println(submit.isDone());

        taskExecutor.shutdown();
    }

}
