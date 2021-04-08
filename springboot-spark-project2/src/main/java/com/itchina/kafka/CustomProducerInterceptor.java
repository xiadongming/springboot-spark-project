package com.itchina.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Date: 2021/3/17 23:08
 * @Desc: kafka的拦截器
 */
//@Component
public class CustomProducerInterceptor implements ProducerInterceptor<String, String> {
    private int successCount = 0;
    private int errorCount = 0;

    /**
     * 消息发送之前调用此方法
     * 将消息序列化和计算分区之前调用，对消息进行定制化操作
     */
    // 发送消息之前加上时间戳
    @Override
    public ProducerRecord onSend(ProducerRecord record) {
        System.out.println("kafka拦截器执行");
        return new ProducerRecord<>(record.topic(), (String) record.key(), System.currentTimeMillis() + "," + record.value());
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception exception) {
        if (exception == null) {
            successCount++;
            System.out.println("当前成功计数:" + successCount);
        } else {
            errorCount++;
            System.out.println("当前失败计数:" + errorCount);

        }
    }

    @Override
    public void close() {
        // 关闭的时候执行 Springboot 项目一般不会关闭~
        System.out.println("发送成功" + successCount);
        System.out.println("发送失败" + errorCount);
    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
