package com.itchina.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Date: 2021/4/16 15:07
 * @Desc:
 */
public class MyLockTest {

    public static void main(String[] args) {

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        reentrantReadWriteLock.readLock();
    }

}
