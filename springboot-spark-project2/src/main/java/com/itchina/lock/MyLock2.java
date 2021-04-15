package com.itchina.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Date: 2021/4/15 22:27
 * @Desc: 实现自定义锁    不可重入性
 */
public class MyLock2 implements Lock {
    /**
     * 是否获取锁，锁标志位
     */
    private boolean isLocked = false;


    @Override
    public synchronized void lock() {
        /**
         * 1-判断锁标志位
         * 如果是第二条线程及其之后的线程，进行wait阻塞
         *     第一条线程，则获取锁
         * 2-可重入性
         * */
        Thread currentThread = Thread.currentThread();
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
    }


    @Override
    public synchronized void unlock() {
        isLocked = false;
        /**
         * 将等待中的线程唤醒
         * */
        notify();
    }

    /**
     *
     */
    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }


    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public Condition newCondition() {
        return null;
    }
}
