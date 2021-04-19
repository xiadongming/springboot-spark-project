package com.itchina.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Date: 2021/4/17 9:52
 * @Desc:
 */
public class ReadWriteLockTest implements ReadWriteLock{


    @Override
    public Lock readLock() {
        return null;
    }

    @Override
    public Lock writeLock() {
        return null;
    }

    public static void main(String[] args) {

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        reentrantReadWriteLock.readLock().lock();
        reentrantReadWriteLock.readLock().tryLock();


        reentrantReadWriteLock.writeLock().lock();
        reentrantReadWriteLock.writeLock().tryLock();

    }
}
