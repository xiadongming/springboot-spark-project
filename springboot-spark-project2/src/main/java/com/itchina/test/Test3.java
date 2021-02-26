package com.itchina.test;

import com.itchina.bo.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2021/2/24 22:22
 * @描述:
 */
public class Test3 {

    public static void main(String[] args) {

        Map<Student, Object> studentObjectHashMap = new HashMap<Student, Object>();

        Student aa = new Student("11", "aa");
        Student bb = new Student("22", "bb");
        studentObjectHashMap.put(aa,"1000");
        studentObjectHashMap.put(bb,"2000");

        aa.setId("33");

        studentObjectHashMap.remove(aa);//删除不了，因为id被修改了，id参与计算hashCode了
        System.out.println(studentObjectHashMap);


        /** 汉字个数校验 */
        String str = "沈阳艾利卡电器有限公司N北一路万达华为专卖01沈阳艾利卡电器有限公司N北一路万达华为专卖01沈阳艾利卡电器有限公司N北一路万达华为专卖01沈阳艾利卡电器有限公司N北一路万达华为专卖01";
        int length = str.length();
        System.out.println("字符串长度："+str.length());

    }
}
