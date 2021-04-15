package com.itchina.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/4/12 18:01
 * @Desc:
 */
public class SubListDets {

    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        objects.add("1");
        objects.add("2");
        objects.add("3");
        objects.add("4");
        objects.add("5");

        List<Object> objects1 = objects.subList(0, 2);
        System.out.println(objects);
        System.out.println(objects1);
        objects.set(0,11111);

        System.out.println(objects);
        System.out.println(objects1);


    }

}
