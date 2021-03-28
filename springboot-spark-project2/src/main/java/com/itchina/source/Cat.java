package com.itchina.source;

/**
 * @Date: 2021/3/28 11:00
 * @Desc:
 */
public class Cat {

    public String name;
    public String addRess;

    public Cat(String name, String addRess) {
        this.addRess = addRess;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddRess() {
        return addRess;
    }

    public void setAddRess(String addRess) {
        this.addRess = addRess;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", addRess='" + addRess + '\'' +
                '}';
    }
}
