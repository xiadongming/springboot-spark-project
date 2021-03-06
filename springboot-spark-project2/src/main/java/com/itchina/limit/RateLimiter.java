package com.itchina.limit;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Date: 2021/3/6 16:54
 * @Desc:  限流标记位,redis分布式限流
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface RateLimiter  {
    int seconds();
    int maxCount();
    boolean needLogin() default true;
}
