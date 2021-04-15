package com.itchina.beancopy;

import java.util.List;

/**
 * @Date: 2021/4/12 18:19
 * @Desc:
 */
public class BasePO2 {


    private String name;
    private String addr;
    private List<UsreInfo2> userInfolist;
    private List<Object> userInfolist3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public List<UsreInfo2> getUserInfolist() {
        return userInfolist;
    }

    public void setUserInfolist(List<UsreInfo2> userInfolist) {
        this.userInfolist = userInfolist;
    }

    public List<Object> getUserInfolist3() {
        return userInfolist3;
    }

    public void setUserInfolist3(List<Object> userInfolist3) {
        this.userInfolist3 = userInfolist3;
    }

    @Override
    public String toString() {
        return "BasePO2{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", userInfolist=" + userInfolist +
                ", userInfolist3=" + userInfolist3 +
                '}';
    }
}
