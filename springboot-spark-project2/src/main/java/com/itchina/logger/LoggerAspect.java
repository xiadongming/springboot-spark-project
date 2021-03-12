package com.itchina.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

import java.lang.reflect.Method;

/**
 * @Date: 2021/3/12 15:16
 * @Desc: 日志切面类
 */
@Aspect
@Component
public class LoggerAspect {

    @Autowired
    private LoggerService loggerService;

    /**
     * 日志切入点
     */
    @Pointcut("@annotation(com.itchina.logger.LoggerBody)")
    public void logPointCut(){}

    @AfterReturning(pointcut = "logPointCut()")
    public void doAfter(JoinPoint joinPoint){
        /**
         * 解析Log注解
         */
        String methodName = joinPoint.getSignature().getName();
        Method method = currentMethod(joinPoint,methodName);
        LoggerBody loggerBody = method.getAnnotation(LoggerBody.class);
        loggerService.put(joinPoint,methodName,loggerBody.module(),loggerBody.description());
    }
    /**
     * 获取当前执行的方法
     *
     * @param joinPoint  连接点
     * @param methodName 方法名称
     * @return 方法
     */
    private Method currentMethod(JoinPoint joinPoint, String methodName) {
        /**
         * 获取目标类的所有方法，找到当前要执行的方法
         */
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method resultMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }

}
