package com.itchina.finl;

/**
 * @Date: 2021/4/19 8:01
 * @Desc: final 关键字的内存语义
 */
public class FinalTest {

    private int a = 100;
    private   final int b ;

    /**
     * 允许在构造方法中发生,但不能发生在构造方法之后发生
     * */
    public FinalTest() {
        b =200;
    }
    /**
     * 代码块在构造方法之前发生，允许final域在代码块中写操作
     * */
    {
       // b=200;
    }
    /**
     *代码块在构造方法之前发生，允许final域在代码块中写操作
     * */
   /* static {
        b=200;
    }*/
}
