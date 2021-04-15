package com.itchina.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Date: 2021/4/14 17:12
 * @Desc:
 */
public class MyAqs extends AbstractQueuedSynchronizer {

    protected MyAqs() {
        super();
    }

    @Override
    protected boolean tryAcquire(int i) {
        return super.tryAcquire(i);
    }

    @Override
    protected boolean tryRelease(int i) {
        return super.tryRelease(i);
    }

    @Override
    protected int tryAcquireShared(int i) {
        return super.tryAcquireShared(i);
    }

    @Override
    protected boolean tryReleaseShared(int i) {
        return super.tryReleaseShared(i);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
