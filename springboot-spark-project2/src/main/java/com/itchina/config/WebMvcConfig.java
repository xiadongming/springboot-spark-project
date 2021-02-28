package com.itchina.config;

import com.google.common.util.concurrent.RateLimiter;
import com.itchina.intercepter.JWTIntercepter;
import com.itchina.intercepter.RateLimiterInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

/**
 * @Date: 2021/2/27 21:37
 * @Desc: springmvc配置类
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private JWTIntercepter jWTIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /** 添加token拦截器 */
        registry.addInterceptor(jWTIntercepter)
                 .addPathPatterns("/devJwt/address");//路径是"/devJwt/address"的时候才会进入jWTIntercepter

        /** 添加限流拦截器 */
        registry.addInterceptor(new RateLimiterInterceptor(RateLimiter.create(1, 1, TimeUnit.SECONDS)))//1秒钟生成1个令牌，也就是1秒中允许一个人访问
                .addPathPatterns("/rate/limit");

    }
}
