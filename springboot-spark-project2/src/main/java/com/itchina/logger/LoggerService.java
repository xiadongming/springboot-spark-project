package com.itchina.logger;

import org.aspectj.lang.JoinPoint;

/**
 * @Date: 2021/3/11 16:25
 * @Desc:  日志系统
 */
public interface LoggerService {
    public void put(JoinPoint joinPoint, String methodName, String module, String description);
}
