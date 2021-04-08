package com.itchina.asyncrequest;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @Date: 2021/3/31 21:29
 * @Desc:
 */

@Service
public class AsyncRequestOne {

    /**
     * 异步任务，会创建线程处理，
     * 1-会创建线程进行处理
     * 2-可以配置一个线程池进处理
     */
    //@Async  可以，或者如下
    @Async("getAsyncExecutor")
    public Object asyncRequest() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("service====>>>"+Thread.currentThread().getName());
        System.out.println("异步请求，无无无返回值");

        return "successful";
    }
    /**
     * 只是交给不同的线程去处理，但是还是需要等待有返回结果才返回
     * 会等待直到有返回结果，
     * */
    @Async("getAsyncExecutor")
    public Future<String> asyncFutureRsp() throws InterruptedException {
        System.out.println("service====>>>"+Thread.currentThread().getName());
        System.out.println("异步请求，有有有返回值");
        Thread.sleep(5000);
        return new AsyncResult<>("successful");
    }
}
