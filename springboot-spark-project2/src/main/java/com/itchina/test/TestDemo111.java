package com.itchina.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Date: 2021/4/14 17:46
 * @Desc:  值传递 和 引用传递
 */
public class TestDemo111 {

    private static Pattern patBlank = Pattern.compile("\\s*|\t|\r|\n");

    public static void main(String[] args) {

        String str= "18945445555/\n" + "上傻";
        String str22= "18945445555/\n" + "上傻222";
        System.out.println(str);
        System.out.println(str22);
        System.out.println("===============");
        test2(str,str22);

        System.out.println(str22);
        System.out.println(str);
        System.out.println(">>>>>>>>>>");
        String s = replaceBlank( str22);
        System.out.println(s);
        System.out.println(test(str,str22));
    }

    private static String test(String str, String str22) {
        str = replaceBlank(str);
        str22 = replaceBlank(str22);
        //str22   --> "111"
        //str22   --> 222
        return str22;
    }
    /**
     * 值传递。。。str，，，str222是地址信息，
     * 该方法结束之后，左侧的 str22 消失,，test()中的str22引用并没有变化，str22的值还是上一级的值
     *                                如果test()有返回值，如test2就会返回新值，因为str22指向了新的地址
     * */
    private static void test2(String str, String str22) {
        str = replaceBlank(str);
        str22 = replaceBlank(str22);
        //str22   --> "111"
        //str22   --> 222
    }

    public static String replaceBlank(String str) {
        if (null != str) {
            Matcher m = patBlank.matcher(str);
            str = m.replaceAll("");
        }
        return str;
    }
}
