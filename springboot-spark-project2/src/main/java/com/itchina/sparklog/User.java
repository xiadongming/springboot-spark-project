package com.itchina.sparklog;

import java.io.Serializable;

/**
 * @Date: 2021/3/14 20:25
 * @Desc: 用于sparkStereaming生成日志使用
 */
public class User implements Serializable {


    private String id;
    private String name;

    private String time;

    public User() {
    }

    public User(String id, String name, String time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
