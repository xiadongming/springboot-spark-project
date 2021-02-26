package com.itchina.test;

/**
 * @Date: 2021/2/26 21:40
 * @描述: cpu100%的情况
 */
public class Cpu100 {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                int result = 0;
                while (true) {
                    result++;
                    if (result > Integer.MAX_VALUE / 2) {
                        result = 0;
                    }
                }
            }
        }.start();
    }

}
