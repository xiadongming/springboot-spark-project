package com.itchina.pool;

import java.util.concurrent.Callable;

/**
 * @Date: 2021/4/27 17:43
 * @Desc:
 */
public class CallableServiceImpl implements Callable<Object> {
    @Override
    public Object call() throws Exception {

        //while (true){
            //Thread.sleep(50);
            System.out.println("name= " + Thread.currentThread().getName());
        //}

        return "successful";
    }
}
