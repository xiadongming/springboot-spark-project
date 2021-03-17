package com.itchina.common;

import java.io.Serializable;

/**
 * @Date: 2021/3/12 18:44
 * @Desc: 定义用户基类，继承这个类即可获取用户信息
 *        待实现
 */
public class UserInfoBaseBO implements Serializable {
    private String name;

    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserInfoBaseBO{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
