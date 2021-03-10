package com.itchina.test.http;

import com.alibaba.fastjson.JSON;
import com.itchina.bo.Student;
import com.itchina.http.HttpClientUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/3/10 14:04
 * @Desc:  生产环境下，需要做内网ip
 */
@RestController
@RequestMapping("/http")
public class HttpClientTestController {


    /**
     * 将请求转发给其他工程中的controller
     * */
    @RequestMapping(value = "/get", method = {RequestMethod.GET, RequestMethod.POST})
    public Object httpGet() {
        String url = "http://localhost:9100/dev/value";
        String response = HttpClientUtils.doGET(url);
        return response;
    }


    /**
     * 将请求转发给同工程中的controller
     * */
    @RequestMapping(value = "/get2", method = {RequestMethod.GET, RequestMethod.POST})
    public Object httpGet2() {
        String url = "http://localhost:9123/http/reGet";
        String response = HttpClientUtils.doGET(url);
        return response;
    }
    @RequestMapping(value = "/reGet", method = {RequestMethod.GET, RequestMethod.POST})
    public Object reHttpGet() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        return "good";
    }

    /**
     * post请求,本工程中的controller
     * */
    @RequestMapping(value = "/post", method = {RequestMethod.GET, RequestMethod.POST})
    public Object httpPost() {
        String url = "http://localhost:9123/http/rePost";
        Student student = new Student("123","zhangsan");
        String studentString = JSON.toJSONString(student);
        String response = HttpClientUtils.doPost(url,studentString);
        return response;
    }

    /**
     * post请求,其他工程中的controller
     * */
    @RequestMapping(value = "/postOther", method = {RequestMethod.GET, RequestMethod.POST})
    public Object httpPost2() {
        String url = "http://localhost:9100/dev/valuePost";
        Student student = new Student("123","zhangsan");
        String studentString = JSON.toJSONString(student);
        String response = HttpClientUtils.doPost(url,studentString);
        return response;
    }
    @RequestMapping(value = "/rePost", method = {RequestMethod.GET, RequestMethod.POST})
    public Object reHttpPost(@RequestBody Student student) {
        System.out.println(">>>>student>>> " + student);
        return "good";
    }

}
