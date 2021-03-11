package com.itchina.test.http;

import com.itchina.bo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Date: 2021/3/11 10:58
 * @Desc:
 */
@Controller
@RequestMapping("/dev")
public class TestController2 {

    @RequestMapping(value = "/post", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object getTest(@RequestBody Student student) {
        System.out.println("student= " + student);
        return student;
    }

}
