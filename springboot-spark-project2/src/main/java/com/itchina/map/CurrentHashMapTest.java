package com.itchina.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * @Date: 2021/4/12 15:02
 * @Desc:  putIfAbsent ：如果原始key已经存在，则不更新value
 *                       如果key不存在，则可以更新value
 *
 *         computeIfPresent：如果key已存在，则会计算新的值
 *                              key不存在，则不会进行计算
 *
 */
public class CurrentHashMapTest {
    static Map<Object,Object> currentMap = new ConcurrentHashMap();
    public static void main(String[] args) {
        currentMap.putIfAbsent("testKey","100");
        currentMap.putIfAbsent("testKey","300");
        //currentMap.computeIfPresent();
        System.out.println(currentMap);

        currentMap.computeIfPresent("testKey",(key,value) -> "10000");
        currentMap.computeIfPresent("testKey2",(key,value) -> "10000");
        System.out.println(currentMap);

    }

}
