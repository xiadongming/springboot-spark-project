package com.itchina.test;

import com.itchina.bo.Picture;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/2/24 21:34
 * @描述: 内存泄露的情况：即生命周期一直没有结束
 * 静态变量：生命周期和类CacheGC相同，即和jvm进程相同，不会得到回收，
 * 就算所属类被回收，static也不会被回收，因为static是先于类加载的，是jvm进程级别的
 * 成员变量：如果成员变量所属的对象被回收，这个成员变量会一起被回收
 * 局部变量：方法执行完毕，生命周期就结束，垃圾回收器就进行回收
 */
public class CacheGC {
    static List<Picture> pictureList = new ArrayList<Picture>();
    List<Picture> pictureList2 = new ArrayList<Picture>();
    public static void main(String[] args) {
        Picture picture = new Picture();
        pictureList.add(picture);
        pictureList = null;
    }
    public String test1() {
        Picture picture = new Picture();
        pictureList2.add(picture);
        pictureList2 = null;
        return null;
    }
}
