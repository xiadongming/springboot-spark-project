package com.itchina.test;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Date: 2021/4/7 10:20
 * @Desc: 去掉换行符，tab键
 *         \n 回车(\u000a)
 *         \t 水平制表符(\u0009)
 *         \s 空格(\u0008)
 *         \r 换行(\u000d)
 */
public class TestDemo22 {
    public static void main(String[] args) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("abc",null);
        System.out.println(null == stringObjectHashMap.get("abc"));
        System.out.println(null == String.valueOf(stringObjectHashMap.get("abc")));
        System.out.println(StringUtils.isNotBlank(String.valueOf(stringObjectHashMap.get("abc"))));

        System.out.println("null".equals(String.valueOf(stringObjectHashMap.get("abc"))));
    }

}
