package com.itchina.intercepter;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Date: 2021/2/28 12:33
 * @Desc: 基于sentinel实现自定义限流规则
 *        限流之后才会进入handle方法之中
 */
@Component
public class MyLimiterBlockHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        System.out.println("限流====");
    }
}
