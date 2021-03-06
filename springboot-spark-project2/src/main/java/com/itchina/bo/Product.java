package com.itchina.bo;

/**
 * @Date: 2021/3/6 23:13
 * @Desc:
 */
public class Product {
    private static int number = 5;

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        Product.number = number;
    }
}
