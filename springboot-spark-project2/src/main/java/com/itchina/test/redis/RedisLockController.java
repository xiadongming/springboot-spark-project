package com.itchina.test.redis;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Date: 2021/2/28 16:13
 * @Desc: redis分布式锁  redsession分布式锁
 */
@RestController
@RequestMapping("/redis")
public class RedisLockController {

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping(value = "/lock", method = {RequestMethod.GET, RequestMethod.POST})
    public String redisLock() {
        System.out.println(Thread.currentThread().getName() + "  " + System.currentTimeMillis());
        RLock lock = redissonClient.getLock("lock_name");
        System.out.println(Thread.currentThread().getName() + "  " + "获取锁");
        System.out.println(Thread.currentThread().getName() + "  " + System.currentTimeMillis());
        try {
            /**
             * 尝试获取锁，最多等待10秒，上锁之后10秒后释放锁
             * */
            //boolean b = lock.tryLock(100, 10, TimeUnit.MICROSECONDS);
            /**
             * 30秒之后，释放锁
             * */
            boolean booleanLock = lock.tryLock(30, TimeUnit.MICROSECONDS);//获取锁之后才走和unlock之间的代码
            System.out.println(Thread.currentThread().getName() + "  " + "获取锁222");
            if (booleanLock) {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "  " + "释放锁");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return "successful";
    }

}
