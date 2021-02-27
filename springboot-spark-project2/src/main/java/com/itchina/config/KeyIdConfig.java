package com.itchina.config;

import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2021/2/27 12:30
 * @描述:
 */
@Configuration
public class KeyIdConfig {
    @Bean("userKeyGenerator")
    public SnowflakeShardingKeyGenerator userKeyGenerator() {
        return new SnowflakeShardingKeyGenerator();
    }
}
