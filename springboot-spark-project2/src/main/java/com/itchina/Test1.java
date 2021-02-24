package com.itchina;

public class Test1 {
    public static void main(String[] args) {

        String name = "  河  南 ";

        String s = name.replaceAll(" ", "");
        System.out.println(name);
        System.out.println(s);

    }
}
