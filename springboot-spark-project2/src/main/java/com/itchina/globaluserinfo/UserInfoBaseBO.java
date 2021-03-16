package com.itchina.globaluserinfo;

/**
 * @Date: 2021/3/15 14:58
 * @Desc: 用于存储当前登录用户信息，是一个全局类
 *        继承
 *        四种获取当前登录用户信息的方式
 *        第一种：ThreadLocal，每个线程中都存储用户信息，不用在从session中获取
 *        第二种：从UserInfoBaseBO中获取， -- 未实现
 *        第三种：从security安全框架中获取
 *        第四种：定义一个单例模式，也是全局共享
 */
public class UserInfoBaseBO {
}
