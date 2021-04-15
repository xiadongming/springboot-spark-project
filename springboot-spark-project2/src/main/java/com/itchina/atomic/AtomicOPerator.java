package com.itchina.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Date: 2021/4/15 22:08
 * @Desc: 原子操作
 */
public class AtomicOPerator {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        int andAdd = atomicInteger.getAndAdd(244);
        System.out.println(andAdd); //1
        int andAdd2 = atomicInteger.getAndAdd(2);
        System.out.println(andAdd2);


        boolean b = atomicInteger.compareAndSet(2, 4);
        boolean b2 = atomicInteger.compareAndSet(247, 4);
        System.out.println(b);
        System.out.println(b2);
        System.out.println(atomicInteger.getAndAdd(2));


        //atomicInteger.getAndUpdate()

    }
}
