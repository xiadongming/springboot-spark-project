package com.itchina.test;

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
public class TestDemo21 {
    public static void main(String[] args) {

        String abc = "想挨打的 \n 阿大大的";
        String s = abc.replaceAll(" ", "");
        System.out.println(s);
        System.out.println(abc);
        System.out.println(abc.replaceAll("\n",""));
        System.out.println(replaceBlank(abc));

    }
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
