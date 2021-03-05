package com.itchina.test.zk;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/3/5 10:19
 * @Desc: zk的分布式锁
 */
@RestController
@RequestMapping("/zk")
public class ZookeeperLock {

    @RequestMapping(value = "/lock",method = {RequestMethod.GET,RequestMethod.POST})
    public Object getZkLock(){
        return null;
    }

}
