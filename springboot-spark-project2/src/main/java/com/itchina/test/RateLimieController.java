package com.itchina.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/2/28 10:10
 * @Desc:
 */
@RestController
@RequestMapping("/rate")
public class RateLimieController {


    @RequestMapping(value = "/limit",method = {RequestMethod.GET,RequestMethod.POST})
    public String  test1(){

        return "successful";
    }

}
