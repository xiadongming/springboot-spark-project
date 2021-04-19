package com.itchina.waitnoyifyjoin;

/**
 * @Date: 2021/4/18 18:32
 * @Desc:
 */
public class JoinTest {


    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread();
        Thread thread2 = new Thread();


        thread1.start();
        thread1.join();
        thread2.start();
    }

}
