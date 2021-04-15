package com.itchina.design;

/**
 * @Date: 2021/4/15 7:40
 * @Desc: 懒汉式, 双重检验锁
 */
public class Singleton1 {

    public static volatile Singleton1 singleton = null;

    /**
     * synchronized不能加在方法体上，因为性能能不高，造成自旋
     */
    //public static synchronized  Singleton1 getInstabce() {
    public static Singleton1 getInstabce() {
        /**
         * 类锁
         * */
        if (null == singleton) {
            synchronized (Singleton1.class) {
                if (null == singleton) {
                    singleton = new Singleton1();
                }
            }
        }
        return singleton;
    }
}
