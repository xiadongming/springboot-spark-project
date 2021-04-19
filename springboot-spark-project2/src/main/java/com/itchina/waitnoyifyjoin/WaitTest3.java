package com.itchina.waitnoyifyjoin;

/**
 * @Date: 2021/4/18 7:49
 * @Desc: 生产者消费者模式
 */
public class WaitTest3 implements Runnable {

    private Object obj = new Object();
    private int account = 0;

    public static void main(String[] args) {
        WaitTest3 waitTest3 = new WaitTest3();
        Thread thread1 = new Thread(waitTest3,"奇数");
        Thread thread2 = new Thread(waitTest3,"偶数");

        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        while (account < 100) {
            synchronized (obj) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account ++;
                obj.notify();
                System.out.println(Thread.currentThread().getName() + ",,," + account);
                if (account < 100){
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
