package com.itchina.bo;

/**
 * @Date: 2021/2/24 22:02
 * @描述:
 */
public class Student {

    private String id;

    private String name;

    @Override
    public int hashCode() {
        /**
         * id参与计算hashCode
         * */
        int result = Integer.parseInt(id) + 100;
        return result;
    }
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
