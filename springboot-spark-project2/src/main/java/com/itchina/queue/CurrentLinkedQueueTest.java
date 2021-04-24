package com.itchina.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Date: 2021/4/19 7:18
 * @Desc:
 */
public class CurrentLinkedQueueTest {
    public static void main(String[] args) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();

        concurrentLinkedQueue.add("");
        concurrentLinkedQueue.poll();


        concurrentLinkedQueue.offer("");

    }
}


 