package com.itchina.lock;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Date: 2021/4/17 22:33
 * @Desc: 锁降级案例
 */
public class LockDownDemo {
    HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    Lock readLock = reentrantReadWriteLock.readLock();
    Lock writeLock = reentrantReadWriteLock.writeLock();

    private volatile boolean isUpdate;

    /**
     * ReentrantReadWriteLock 的读锁和写锁
     * 1-同一个锁，读锁和读锁可以共享的
     * 2-同一个锁，读锁和写锁是排他的
     *           读锁和读锁是排他的
     * */
    public void readWrite() {
        Condition condition = readLock.newCondition();
        readLock.lock();
        if(isUpdate){
            readLock.unlock();

            writeLock.lock();//写锁开始
            objectObjectHashMap.put("abc","ok");

            readLock.lock();//在写锁释放之前，获取到度搜 (1) //重要，为了get("abc")的时候，数据安全没有被修改
            writeLock.unlock();//写锁结束                 //     因为读锁未释放，只有一个线程，修改之后，读锁锁定，

        }

        Object abc = objectObjectHashMap.get("abc");
        readLock.unlock();//读锁释放
    }
}
