package com.itchina.test.redis;

import com.itchina.distrilock.redislock.RedSessionManager;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Date: 2021/3/28 15:30
 * @Desc: redsession分布式锁
 * 参看 RedisLockController
 */
@RestController
@RequestMapping("redisson")
public class RedisRedSessionLoclController {
    @Autowired
    private RedSessionManager redSessionManager;
    @RequestMapping(value = "/redisson", method = {RequestMethod.GET, RequestMethod.POST})
    public Object testRedisson()  {
        RLock lock = redSessionManager.getRedisson().getLock("lock_name");
        /**
         * 尝试获取锁，最多等待10秒，上锁之后10秒后释放锁
         * */
        //boolean b = lock.tryLock(100, 10, TimeUnit.MICROSECONDS);
        /**
         * 30秒之后，释放锁
         * */
        try {
            boolean booleanLock = lock.tryLock(30, TimeUnit.MICROSECONDS);//获取锁之后才走和unlock之间的代码
            if(booleanLock){
                System.out.println("获取到锁");
            }else {
                System.out.println("没有获取锁");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return "successful";
    }
}
