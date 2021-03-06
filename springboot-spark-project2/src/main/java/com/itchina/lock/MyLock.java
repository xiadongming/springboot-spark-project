package com.itchina.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Date: 2021/4/15 22:27
 * @Desc: 实现自定义锁    可重入性
 */
public class MyLock implements Lock {
    /**
     * 是否获取锁，锁标志位
     */
    private boolean isLocked = false;

    /**
     * 通过判断锁的所有者，实现锁的可重入性
     */
    private Thread owner = null;
    /**
     * 可重入的计数器
     */
    private int lockCount = 0;

    @Override
    public synchronized void lock() {
        /**
         * 1-判断锁标志位
         * 如果是第二条线程及其之后的线程，进行wait阻塞
         *     第一条线程，则获取锁
         * 2-可重入性
         * */
        Thread currentThread = Thread.currentThread();
        while (isLocked || currentThread != owner) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        owner = currentThread;
        lockCount++;
    }


    @Override
    public synchronized void unlock() {
        Thread currentThread = Thread.currentThread();
        if (currentThread == owner) {
            lockCount -- ;
            if(lockCount == 0){
                isLocked = false;
                /**
                 * 将等待中的线程唤醒
                 * */
                notify();
            }
        }
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
