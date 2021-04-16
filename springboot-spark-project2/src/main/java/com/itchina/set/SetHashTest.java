package com.itchina.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @Date: 2021/4/16 11:46
 * @Desc:
 */
public class SetHashTest {
    public static void main(String[] args) {
        Set<Object> objects = new HashSet<>();
        objects.add(null);
        System.out.println(objects.add(null));
    }
}
