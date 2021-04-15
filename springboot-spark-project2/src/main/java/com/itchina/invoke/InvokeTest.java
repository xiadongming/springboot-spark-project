package com.itchina.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Date: 2021/4/1 10:43
 * @Desc: invoke的使用
 */
public class InvokeTest {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {

        Class<?> aClass = Class.forName("com.itchina.invoke.InvokeServiceImpl");
        Method[] methods = Class.forName("com.itchina.invoke.InvokeServiceImpl").getMethods();
        try {
            for (Method method : methods) {
                if ("getInvoke".equals(method.getName())) {
                    Object invoke = method.invoke(aClass.getName());
                    System.out.println("返回结果 invoke= " + invoke);
                    System.out.println("返回结果 methodName= " + method.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
