package com.itchina.config;

import com.itchina.intercepter.JWTIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
        registry.addInterceptor(jWTIntercepter)
                 .addPathPatterns("/devJwt/address");//路径是"/devJwt/address"的时候才会进入jWTIntercepter

    }
}
