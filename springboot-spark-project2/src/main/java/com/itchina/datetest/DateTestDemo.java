package com.itchina.datetest;

import java.util.Date;

/**
 * @Date: 2021/3/29 19:43
 * @Desc:
 */
public class DateTestDemo {
    public static void main(String[] args) throws InterruptedException {


        Date date = new Date();

        Thread.sleep(1000);
        Date date2 = new Date();
        long time = date.getTime();
        long time2 = date2.getTime();
        System.out.println((time2 - time) / 1000);
        System.out.println((System.currentTimeMillis() - time) / 1000);

    }

}
