package com.itchina.gateway;

import com.itchina.init.SingleUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.webkit.Invoker;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Date: 2021/3/31 22:06
 * @Desc: 自定义网关，不套用feign，，实现自定义的网关
 *        所有以“/api/” 开头的请求，都从这里入口
 */
@RestController
@RequestMapping("/api")
public class MyGatewayApi {


    /**
     * invoker
     * */
    @RequestMapping(value = "/portal",method = {RequestMethod.GET,RequestMethod.POST})
    public Object getPortal(){


        System.out.println("SingleUtils= " + SingleUtils.cacgeMap);

        return "successful";
    }
}
