package com.itchina.beancopy;

/**
 * @Date: 2021/4/12 18:20
 * @Desc:
 */
public class UsreInfo3 {

    private String userName;
    private String userAddr;
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    @Override
    public String toString() {
        return "UsreInfo1{" +
                "userName='" + userName + '\'' +
                ", userAddr='" + userAddr + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
