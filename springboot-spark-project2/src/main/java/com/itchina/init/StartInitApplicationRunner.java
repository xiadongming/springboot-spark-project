package com.itchina.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Date: 2021/3/31 22:53
 * @Desc:
 */
@Service
public class StartInitApplicationRunner implements ApplicationRunner {
    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        /**
         * 自己封装
         * */
        //SingleUtils.setCacgeMap(redisTemplate.getHashMap());
        HashMap<String,String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("1212","1213");
        SingleUtils.setCacgeMap(objectObjectHashMap);
    }
}
