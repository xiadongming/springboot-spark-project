package com.itchina.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Date: 2021/3/6 17:02
 * @Desc:
 */
@Configuration
public class JedisConfig {
    @Autowired
    private  RedisConfig redisConfig;

    @Bean
    public JedisPool jedisPoolFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
       // poolConfig.setMaxIdle(redisConfig.getPoolMaxdle());
       // poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
       // poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
        JedisPool jedisPool = new JedisPool(poolConfig,redisConfig.getHost(),redisConfig.getPort());
        return jedisPool;

    }
    @Bean
    public Jedis jedisFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
       // poolConfig.setMaxIdle(redisConfig.getPoolMaxdle());
        //poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        //poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
        JedisPool jedisPool = new JedisPool(poolConfig,redisConfig.getHost(),redisConfig.getPort());

        Jedis jedis = jedisPool.getResource();
        return jedis;

    }
}
