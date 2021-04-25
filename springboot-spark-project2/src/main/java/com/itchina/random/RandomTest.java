package com.itchina.random;

import java.util.Random;

/**
 * @Date: 2021/4/20 12:47
 * @Desc:
 */
public class RandomTest {


    public static void main(String[] args) {
        long l = (new Random()).nextLong();
        System.out.println("l= "+l);
        int i = (new Random()).nextInt(4);
        System.out.println("i= " + i);

    }
}
