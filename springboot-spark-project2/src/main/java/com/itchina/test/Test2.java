package com.itchina.test;

import com.itchina.bo.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Date: 2021/2/24 22:01
 * @描述:  内存泄露的情况
 */
public class Test2 {

    public static void main(String[] args) {
        Set<Student> studentHashSet = new HashSet<Student>();

        Student aa = new Student("11", "aa");
        Student bb = new Student("22", "bb");
        studentHashSet.add(aa);
        studentHashSet.add(bb);

        aa.setId("33");
        studentHashSet.remove(aa);//删除失败，因为id参与计算hashcode，但是id的值被修改了，删除的是和set找不到原来的位置，所以不能删除
        System.out.println(studentHashSet);




      /*  List<Student> students = new ArrayList<Student>();
        Student aa = new Student("11", "aa");
        Student bb = new Student("22", "bb");
        students.add(aa);
        students.add(bb);
        aa.setId("33");
        students.remove(aa);
        System.out.println(students);*/


    }
}