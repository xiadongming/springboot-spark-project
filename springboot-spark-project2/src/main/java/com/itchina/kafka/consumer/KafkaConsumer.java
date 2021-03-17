package com.itchina.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @Date: 2021/3/16 20:58
 * @Desc:
 */
@Component
public class KafkaConsumer {
    // 消费监听
    @KafkaListener(id = "consumer1",groupId = "xuewu",topicPartitions={@TopicPartition(topic = "kafka-test-topic", partitions = { "0" })})
    public void onMessage1(ConsumerRecord<?, ?> record,Acknowledgment ack){
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value()+",offset= " + record.offset());
        /**
         * 手动提交offset
         * */
        ack.acknowledge();

    }
    // 消费监听
    @KafkaListener(id = "consumer2",groupId = "xuewu2",topicPartitions={@TopicPartition(topic = "kafka-test-topic", partitions = { "0" })})
    public void onMessage(ConsumerRecord<?, ?> record,Acknowledgment ack){
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费2："+record.topic()+"-"+record.partition()+"-"+record.value()+",offset= " + record.offset());

        /**
         * 手动提交offset
         * */
        ack.acknowledge();

    }

}
