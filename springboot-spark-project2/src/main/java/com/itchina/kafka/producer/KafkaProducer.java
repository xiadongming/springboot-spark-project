package com.itchina.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Date: 2021/3/16 20:58
 * @Desc: kafka消费者
 */
//@Component
public class KafkaProducer {
   /* @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;*/
    // 发送消息
  /*  public void sendMessage1(String normalMessage) {
      //  kafkaTemplate.send("kafka-test-topic", 0,"123",normalMessage);

        *//**
         * 1-没有指定partition、会根据key进行hash，计算出指定的partition
         * 2-没有指定partition，没有指定key，则采用轮训的方式，发送消息
         * 3-如果自定义分区规则，则按照分区规则指定partition
         * *//*
       // kafkaTemplate.send("kafka-test-topic","123",normalMessage);
        *//**
         * 回调函数
         * *//*
        kafkaTemplate.send("kafka-test-topic","123",normalMessage).addCallback(
                success ->{
                    String topic = success.getRecordMetadata().topic();
                    int partition = success.getRecordMetadata().partition();
                    long offset = success.getRecordMetadata().offset();
                    System.out.println("生产者发送成功：topic:" + topic + " partition:" + partition + " offset:" + offset);
                },
                failure ->{
                    String message1 = failure.getMessage();
                    System.out.println("生产者发送失败："+message1);
                }
        );

    }*/

}
