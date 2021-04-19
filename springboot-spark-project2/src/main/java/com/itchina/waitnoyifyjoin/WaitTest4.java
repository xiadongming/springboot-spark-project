package com.itchina.waitnoyifyjoin;

/**
 * @Date: 2021/4/18 7:49
 * @Desc: 交替打印数据
 */
public class WaitTest4 {
    private Object obj = new Object();
    private int account = 0;
    private int singal;// 0-打印a,,,1-b,2-c
    synchronized void a() throws InterruptedException {
        while (singal != 0) {
            wait();
        }
        System.out.println("a");
        singal++;
        notifyAll();
    }
    synchronized void b() throws InterruptedException {
        while (singal != 1) {
            wait();
        }
        System.out.println("b");
        singal++;
        notifyAll();
    }
    synchronized void c() throws InterruptedException {
        while (singal != 2) {
            wait();
        }
        System.out.println("c");
        singal = 0;
        notifyAll();
    }
    public static void main(String[] args) {
        WaitTest4 waitTest4 = new WaitTest4();
        A a = new A(waitTest4);
        B b = new B(waitTest4);
        C c = new C(waitTest4);
        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();
    }
    static class A implements Runnable {
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
    static class B implements Runnable {
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
    static class C implements Runnable {
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
}
