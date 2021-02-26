package com.itchina.test.service;

import java.util.List;

public class PoolListMethodServiceImpl implements Runnable {

    List<String> stringList;

    public PoolListMethodServiceImpl(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public void run() {
        System.out.println("satrtTime= " + System.currentTimeMillis());
        for (String s : stringList) {
            System.out.println(Thread.currentThread().getName() + "_"+s);
        }
        System.out.println("endTime= " + System.currentTimeMillis());
    }
}
