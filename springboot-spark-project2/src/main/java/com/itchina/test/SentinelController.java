package com.itchina.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/2/28 11:27
 * @Desc:
 */
@RestController
@RequestMapping("/sentinel")
public class SentinelController {


    @RequestMapping(value = "/limit",method = {RequestMethod.GET,RequestMethod.POST})
    public String test1(){
        int a = 100 / 0;
        return "hello sentinel";
    }
}
