package com.itchina.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date: 2021/4/16 14:48
 * @Desc:
 */
public class AqsDemo {

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock reentrantLock = new ReentrantLock();

        reentrantLock.lock();
        reentrantLock.tryLock();
        reentrantLock.unlock();
        reentrantLock.lockInterruptibly();

        reentrantLock.tryLock();

    }

}
