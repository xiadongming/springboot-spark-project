package com.itchina.map;

import java.util.HashSet;
import java.util.Set;

/**
 * @Date: 2021/4/21 14:24
 * @Desc:
 */
public class SetTest {

    public static void main(String[] args) {

        String str = "271300";
        System.out.println(str.substring(0,2));

        Set<String> strSet = new HashSet<>();
        strSet.add("abc");
        System.out.println(strSet);

        strSet.clear();
        System.out.println(strSet);

        strSet.add("123");
        System.out.println(strSet);
    }

}
