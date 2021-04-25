package com.itchina.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2021/4/19 14:28
 * @Desc:
 */
public class MapTest {

    public static void main(String[] args) {

        Map<Object, Object> objectObjectHashMap = new HashMap<>();
        System.out.println(objectObjectHashMap.isEmpty());
        System.out.println(objectObjectHashMap == null);
        objectObjectHashMap.put("abc","ok1");
        objectObjectHashMap.put("abc2","ok2");
        objectObjectHashMap.put("abc3","ok3");

        System.out.println(objectObjectHashMap.isEmpty());

    }

}
