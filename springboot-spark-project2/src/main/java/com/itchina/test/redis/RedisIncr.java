package com.itchina.test.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Date: 2021/3/4 16:18
 * @Desc: redis的自增数字，
 */
@RestController
@RequestMapping("/redis")
public class RedisIncr {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 项目启动，取数据常量，作为redis中的初始值
     * 可以配置成数据库常量数据，每次从redis中获取之后，去更新数据库中的值
     */
    AtomicInteger count = new AtomicInteger(10000);

    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getNum() {
        redisTemplate.opsForValue().set("long_key", String.valueOf(count));
        return count;
    }

    @RequestMapping(value = "/incr", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getNumIncr() throws Exception {
        Long long_key = redisTemplate.opsForValue().increment("long_key");
        System.out.println("long_key= " + long_key);
        Long long_key2 = redisTemplate.opsForValue().increment("long_key");
        System.out.println("long_key2= " + long_key2);
        /**
         * 补救措施：
         * 情境一：加入redis挂掉，获取数据失败
         * 情境二：获取redis中数据成功，但是写入数据库失败，
         * 解决方案：
         *   直接查询数据库，并更新数据库，使用synchronized做原子操作
         *   如果数据库查询失败，或者更新失败，直接抛异常
         * */
        Long long_key3 = null;
        try {
            long_key3 = redisTemplate.opsForValue().increment("long_key");
            count.set(long_key3.intValue());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("从redis中获取主键失败");
            synQueryDB();
        }
        System.out.println("long_key2= " + long_key3);
        return long_key + "_" + long_key2 + "_" + count;
    }

    private synchronized void synQueryDB() throws Exception {
        try {
            // 放开即可
            //queryKeyService.selectByKey("key");
            //queryKeyService.updateByKey(count.getAndIncrement());
        } catch (Exception e) {
            throw new Exception("从数据库获取主键失败");
        }
    }
}
