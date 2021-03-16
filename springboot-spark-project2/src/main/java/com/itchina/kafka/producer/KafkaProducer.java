package com.itchina.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Date: 2021/3/16 20:58
 * @Desc: kafka消费者
 */
@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    // 发送消息
    public void sendMessage1(String normalMessage) {
        kafkaTemplate.send("kafka-test-topic", 0,"123",normalMessage);
    }

}
