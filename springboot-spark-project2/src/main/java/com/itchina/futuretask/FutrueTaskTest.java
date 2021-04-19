package com.itchina.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Date: 2021/4/18 20:54
 * @Desc: futureTask测试类
 */
public class FutrueTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallPerson callPerson = new CallPerson();
        FutureTask<String> stringFutureTask = new FutureTask<String>(callPerson);
        Thread thread = new Thread(stringFutureTask);
        thread.start();
    /*    while (!stringFutureTask.isDone()) {
            System.out.println("未执行完毕。。。。。");
            Thread.sleep(1000);
        }*/
        /**
         * 一直阻塞，直到获取结果
         * */
        System.out.println(stringFutureTask.get());
    }
}

class CallPerson implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("开始执行。。。。。。。。。。。");
        Thread.sleep(5000);
        return "successful";
    }
}
