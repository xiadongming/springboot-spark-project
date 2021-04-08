package com.itchina.asyncrequest;

import com.alibaba.fastjson.JSON;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * @Date: 2021/3/31 21:51
 * @Desc:
 */
@Service
public class MyAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        System.out.println("error= " + ex.getMessage());
        System.out.println("method= " + method.getName());
        System.out.println("params= " + JSON.toJSONString(params));
        ex.printStackTrace();
    }
}
