package com.itchina.sparklog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/3/14 20:12
 * @Desc: 用于sparkStreaming生产日志数据
 */
@RestController
@RequestMapping("/logger")
public class LoggerController {
    static final Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @RequestMapping(value = "/prod", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getLogger(@RequestBody String info) {
        logger.info("info>>> {}",info);

        return "successful";
    }

}
