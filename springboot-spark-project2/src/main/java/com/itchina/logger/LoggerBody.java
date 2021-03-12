package com.itchina.logger;

import java.lang.annotation.*;

/**
 * @Date: 2021/3/12 15:15
 * @Desc:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggerBody {
    /**模块*/
    String module() default "";

    /**描述*/
    String description() default "";

}
