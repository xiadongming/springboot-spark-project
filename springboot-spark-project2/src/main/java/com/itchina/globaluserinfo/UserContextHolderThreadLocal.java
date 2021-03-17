package com.itchina.globaluserinfo;

import com.itchina.common.UserInfoBaseBO;

/**
 * @Date: 2021/3/15 15:09
 * @Desc: 从ThreadLocal中获取当前登录用户
 *        全局对象UserInfoBaseBO的集中方法
 *        第一种：ThreadLocal
 *        第二种：seaurity
 *        第三种：UserINfoBaseBO  未实现，没想通
 */
public class UserContextHolderThreadLocal {

    private static ThreadLocal<UserInfoBaseBO> userInfoHolder = new ThreadLocal<>();

    public static void setCurrentUser(UserInfoBaseBO user) {
        if (userInfoHolder.get() == null) {
            //就会和当前的线程进行一一的绑定
            userInfoHolder.set(user);
        }
    }

    //获得当前的用户
    public static UserInfoBaseBO getCurrentUser() {
        return userInfoHolder.get();
    }

    //对ThreadLocal进行清除。因为如果不清除的话，可能会造成内存泄露
    public static void removeCurrentUser() {
        userInfoHolder.remove();
    }
}
