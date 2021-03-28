package com.itchina.source;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Date: 2021/3/28 10:37
 * @Desc: spring 源码相关
 */
public class SpringIOCSource {

    public static void main(String[] args) {
        /**
         * ioc容器
         * */
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.itchina.source");

        annotationConfigApplicationContext.publishEvent(new ApplicationEvent(new String("测试发布事件===")) {
        });

        annotationConfigApplicationContext.close();

    }

}
