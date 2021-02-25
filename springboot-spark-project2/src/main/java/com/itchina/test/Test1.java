package com.itchina.test;

public class Test1 {
    public static void main(String[] args) {

        String name = "  河  南 ";

        String s = name.replaceAll(" ", "");
        System.out.println(name);
        System.out.println(s);

        Long abc = 1L;
        System.out.println(abc.equals(1L));

        System.out.println(abc == 1L);

        System.out.println("==============");
        Long abcd = 299L;
        System.out.println(abcd.equals(299L));

        System.out.println(abcd == 299L);
        System.out.println(abcd == 299L);



    }
}
