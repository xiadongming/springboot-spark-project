package com.itchina.waitnoyifyjoin;

/**
 * @Date: 2021/4/18 7:49
 * @Desc:
 */
public class WaitTest2 {

    public static   Object obj = new Object();
    private volatile int singal;

    public int getSingal() {
        return singal;
    }

    public void setSingal(int singal) {
        this.singal = singal;
    }

    public static void main(String[] args) {

        WaitTest2 waitTest = new WaitTest2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println("修改状态的线程开始执行。。。。");
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    waitTest.setSingal(1);
                    System.out.println("修改成功。。。。");

                    System.out.println("执行notify.......");
                    obj.notifyAll();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    while (waitTest.getSingal() != 1) {
                        try {
                            System.out.println("开始等待。。。。。");
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("singal的值为1，模拟代码执行");
                }
            }
        }).start();
    }
}
