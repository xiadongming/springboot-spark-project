package com.itchina.test;

/**
 * @Date: 2021/3/3 18:04
 * @Desc: return结束一个方法,而不是跳出循环
 */
public class ReturnDemo {

    public static void main(String[] args) {
        String str = statrMethod();
        System.out.println(str);
    }
    private static String statrMethod() {
        for (int i = 0; i < 100; i++) {
            if (i == 50) {
                return "successful";
            }
        }
        return "failed";
    }
}
