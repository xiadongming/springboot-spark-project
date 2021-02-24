package com.itchina;

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
    }
}
