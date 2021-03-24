package com.itchina.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/3/24 18:31
 * @Desc: springSecurity测试
 */
@Controller
@RequestMapping()
public class SecurityController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getTestLogin() {
        System.out.println("login");
        return "login";
    }
    @RequestMapping(value = "/page1/test", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getTest1() {
        System.out.println("访问page1");
        return "page1";
    }
    @RequestMapping(value = "/page2/test", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getTest2() {
        System.out.println("访问page2");
        return "page2";
    }
    @RequestMapping(value = "/page3/test", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getTest3() {
        System.out.println("访问page3");
        return "page3";
    }
}
