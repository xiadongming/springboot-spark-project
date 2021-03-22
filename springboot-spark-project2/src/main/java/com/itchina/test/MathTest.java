package com.itchina.test;

/**
 * @Date: 2021/3/17 17:08
 * @Desc:
 */
public class MathTest {

    public static void main(String[] args) {

        Long abc = 2147483648L; // 128m
        Long abc2 = 6442450944L; // 384
        System.out.println(abc2 / abc );

        Long a = 8589934592L; //8G
        Long b = 3007315968L;
        System.out.println(a / b);

        String abcdsa = "阿萨德撒打算打算的大";


        System.out.println(abcdsa.length());
    }

}
