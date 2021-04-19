package com.itchina.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date: 2021/4/17 9:16
 * @Desc:
 */
public class MyUnLock {

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.tryLock();

        reentrantLock.unlock();

    }
}
