package com.itchina.test.service;

import org.springframework.data.redis.core.RedisTemplate;


public class RedisSetnxServiceImpl implements Runnable{
    private RedisTemplate<String,String> redisTemplate;
    public RedisSetnxServiceImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void run() {
        /**
         * setIfAbsent就是setnx
         * setIfAbsent 是java中的方法
         * setnx 是 redis命令中的方法
         * SETNX key value
         *   将 key 的值设为 value ，当且仅当 key 不存在。
         *   若给定的 key 已经存在，则 SETNX 不做任何动作。
         *   设置成功，返回 1
         *   设置失败，返回 0
         * */
        for (int i = 0;i<100;i++){
            Boolean name2 = redisTemplate.opsForValue().setIfAbsent("name2", "1000");
            System.out.println(Thread.currentThread().getName()+"  "+name2);
        }
    }
}
