package com.itchina.source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2021/3/28 10:59
 * @Desc:
 */
@Configuration
public class BeanConfig {

    @Bean
    public Dog dog(){
        return new Dog("abc","北京-狗");
    }
    @Bean
    public Cat cat(){
        return new Cat("abc","北京-猫");
    }
}
