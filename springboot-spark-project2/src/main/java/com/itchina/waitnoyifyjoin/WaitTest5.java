package com.itchina.waitnoyifyjoin;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date: 2021/4/18 7:49
 * @Desc: 交替打印数据
 */
public class WaitTest5 {
    private int singal;
    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();
    public static void main(String[] args) {
        WaitTest4 waitTest4 = new WaitTest4();
        WaitTest4.A a = new WaitTest4.A(waitTest4);
        WaitTest4.B b = new WaitTest4.B(waitTest4);
        WaitTest4.C c = new WaitTest4.C(waitTest4);
        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();
    }
    private synchronized void a() throws InterruptedException {
        lock.lock();
        while (singal != 0) {
            a.await();
        }
        System.out.println("a");
        singal++;
        b.signal();
        lock.unlock();
    }
    private synchronized void b() throws InterruptedException {
        lock.lock();
        while (singal != 1) {
            b.await();
        }
        System.out.println("b");
        singal++;
        c.signal();
        lock.unlock();
    }
    private synchronized void c() throws InterruptedException {
        lock.lock();
        while (singal != 2) {
            c.await();
        }
        System.out.println("c");
        singal = 0;
        a.signal();
        lock.unlock();
    }
}
class A implements Runnable {
    private WaitTest4 waitTest4;
    public A(WaitTest4 waitTest4) {
        this.waitTest4 = waitTest4;
    }
    @Override
    public void run() {
        while (true) {
            try {
                waitTest4.a();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class B implements Runnable {
    private WaitTest4 waitTest4;
    public B(WaitTest4 waitTest4) {
        this.waitTest4 = waitTest4;
    }
    @Override
    public void run() {
        while (true) {
            try {
                waitTest4.b();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class C implements Runnable {
    private WaitTest4 waitTest4;
    public C(WaitTest4 waitTest4) {
        this.waitTest4 = waitTest4;
    }
    @Override
    public void run() {
        while (true) {
            try {
                waitTest4.c();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
