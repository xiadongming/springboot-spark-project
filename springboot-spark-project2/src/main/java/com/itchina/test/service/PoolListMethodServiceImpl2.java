package com.itchina.test.service;

public class PoolListMethodServiceImpl2 implements Runnable {

    String str;

    public PoolListMethodServiceImpl2(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        System.out.println("satrtTime2= " + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName() + "_" + str);
        System.out.println("endTime2= " + System.currentTimeMillis());
    }
}
