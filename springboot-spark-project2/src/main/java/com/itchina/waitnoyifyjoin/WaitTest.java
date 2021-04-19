package com.itchina.waitnoyifyjoin;

/**
 * @Date: 2021/4/18 7:49
 * @Desc:
 */
public class WaitTest {


    private volatile int singal;

    public int getSingal() {
        return singal;
    }

    public void setSingal(int singal) {
        this.singal = singal;
    }

    public static void main(String[] args) {

        WaitTest waitTest = new WaitTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("修改状态的线程开始执行。。。。");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                waitTest.setSingal(1);
                System.out.println("修改成功。。。。");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //等待信号为1，空转cpu
                while (waitTest.getSingal() != 1) {

                }
                System.out.println("singal的值为1，模拟代码执行");
            }
        }).start();

    }
}
