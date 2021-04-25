package com.itchina.snow;


/**
 * @Date: 2021/4/13 16:20
 * @Desc: 雪花序列
 */
public class SnowFlakeDemo {
    public static void main(String[] args) {

        Sequence instance = Sequence.getInstance();
        long l = instance.nextId();
        System.out.println("l= " + l + ", " + String.valueOf(l).length());

    }
}
