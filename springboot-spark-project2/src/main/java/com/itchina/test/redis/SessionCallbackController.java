package com.itchina.test.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Date: 2021/4/10 11:42
 * @Desc: RedisCallback和SessionCallBack：
 *     作用: 让RedisTemplate进行回调，通过他们可以在同一条连接中执行多个redis命令
 *     SessionCalback提供了良好的封装，优先使用它，redisCallback太复杂还是不要使用为好
 */
@RestController
public class SessionCallbackController {

    @Autowired
    private  StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/SessionCallback",method = {RequestMethod.GET,RequestMethod.POST})
    public Object getTest(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("key1","key1");
        SessionCallback<Objects> sessionCallback = new SessionCallback<Objects>() {
            @Override
            public Objects execute(RedisOperations operations) throws DataAccessException {
                // 1. 已使用的优惠券 Cache 缓存添加
                operations.opsForHash().putAll("key1", objectObjectHashMap);
                // 2. 可用的优惠券 Cache 需要清理
                operations.opsForHash().delete("key1", "key1");
                // 3. 重置过期时间
                operations.expire("key1", 100, TimeUnit.SECONDS);
                operations.expire("key2",100, TimeUnit.SECONDS);
                return null;
            }
        };
        /**
         * pipeline批量执行
         * */
        redisTemplate.executePipelined(sessionCallback);
        return "successful";
    }

}
