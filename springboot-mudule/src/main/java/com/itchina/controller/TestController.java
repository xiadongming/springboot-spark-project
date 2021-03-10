package com.itchina.controller;

import com.itchina.common.Student;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/3/10 15:24
 * @Desc:
 */
@RestController
@RequestMapping("/dev")
public class TestController {

    @RequestMapping(value = "/value",method = {RequestMethod.GET,RequestMethod.POST})
    public Object getTest(){
        System.out.println("================");
        return "success";
    }


    @RequestMapping(value = "/valuePost",method = {RequestMethod.GET,RequestMethod.POST})
    public Object getTest2(@RequestBody Student student){
        System.out.println("================student " + student);
        return "success";
    }

}
