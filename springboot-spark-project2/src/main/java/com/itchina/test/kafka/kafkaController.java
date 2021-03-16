package com.itchina.test.kafka;

import com.itchina.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/3/16 22:35
 * @Desc:
 */
@RestController
@RequestMapping("/dev")
public class kafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping(value = "/kafka",method = {RequestMethod.GET,RequestMethod.POST})
    public Object getTest(){
        kafkaProducer.sendMessage1("精通java");

        return "successful";
    }

}
