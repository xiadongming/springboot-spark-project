package com.itchina.distrilock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2021/2/28 15:53
 * @Desc: redis的分布式锁
 */
@Configuration
public class RedisLockConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Bean
    public RedissonClient redissonClient() {

        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + host + ":" + port);
        //添加主从配置
        //config.useMasterSlaveServers().setMasterAddress("").setPassword("").addSlaveAddress(new String[]{"",""});

        return Redisson.create(config);
    }

}
