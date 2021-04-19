package com.itchina.threadlocal;

/**
 * @Date: 2021/4/18 18:45
 * @Desc:
 */
public class ThreadLocalTest {


    public static void main(String[] args) {

        ThreadLocal objectThreadLocal = new ThreadLocal<Integer>(){
            @Override
            protected Integer initialValue() {
                return new Integer(0);
            }
        };


        objectThreadLocal.set("");
        Object o = objectThreadLocal.get();

    }

}
