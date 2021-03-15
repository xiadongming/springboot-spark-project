package com.itchina.sparklog;

import com.alibaba.fastjson.JSON;
import com.itchina.http.HttpClientUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Date: 2021/3/14 20:31
 * @Desc:
 */
@RestController
@RequestMapping("/logger")
public class SendHttpProdLogger {

    private String url = "http://localhost:9123/logger/prod";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    @RequestMapping(value = "/send", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getLogger() {


        System.out.println("发送成功");
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(i + "");
            user.setName("name" + i);
            user.setTime(simpleDateFormat.format(new Date()));
            HttpClientUtils.doPost(url, user.toString());
        }
        return "send successful";
    }

}
