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

        /**
         * 这种处理是不对的，，线程池只会用上一条
         * 正确的参看 ThreadPool4
         * */
        Future<Object> submit = taskExecutor.submit(new CallableServiceImpl());

        System.out.println("主线程");
        System.out.println(submit.get());
        System.out.println(submit.isDone());

        System.out.println("结束");
        taskExecutor.shutdown();
    }

}
