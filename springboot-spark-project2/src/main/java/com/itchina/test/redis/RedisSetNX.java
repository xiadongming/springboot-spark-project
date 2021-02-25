package com.itchina.test.redis;

import com.itchina.test.service.RedisSetnxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;

/**
 * 测试redis的setnx分布式锁
 * */
@RestController
@RequestMapping("/redis")
public class RedisSetNX {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private  Executor asyncServiceExecutor;

    @RequestMapping(value = "/setnx",method = {RequestMethod.GET,RequestMethod.POST})
    public void getTest(){
        Boolean abcds = redisTemplate.delete("abcds");
        Boolean abcds2 = redisTemplate.delete("name");
        System.out.println(abcds);
        System.out.println(abcds2);
        //asyncServiceExecutor.execute(new RedisSetnxServiceImpl(redisTemplate));

    }
}
