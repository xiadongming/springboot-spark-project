package com.itchina.distrilock.redislock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Date: 2021/3/28 15:52
 * @Desc:
 */
@Component
public class RedSessionManager {

    private Config config = new Config();
    private Redisson redisson;
    public Redisson getRedisson() {
        return redisson;
    }
    /**
     * 初始化的时候，会执行
     */
    @PostConstruct
    public void init() {
        try {
            config.useSingleServer().setAddress(String.valueOf(new StringBuilder().append("127.0.0.1").append(":").append("6379")));
            redisson = (Redisson)Redisson.create(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
