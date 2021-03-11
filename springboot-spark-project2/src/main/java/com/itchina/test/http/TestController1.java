package com.itchina.test.http;

import com.alibaba.fastjson.JSON;
import com.itchina.bo.Student;
import com.itchina.http.HttpClientUtils;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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
@RequestMapping("/http")
public class TestController1 {

    @RequestMapping(value = "postOther2", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object getTest() {
        Student student = new Student("2121", "1212");

        String s = HttpClientUtils.doPost("http://localhost:9123/dev/post", JSON.toJSONString(student));
        System.out.println("s= " + s);
        return s;
    }

}
