package com.itchina.kafka;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Date: 2021/3/17 21:50
 * @Desc: 自定义分区，即生产者将消息发送到指定的分区的规则
 */
@Component
public class MyPartitionRules implements Partitioner {

    @Override
    public int partition(String topic, Object o, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
        System.out.println("自定义分区");
        /**
         * 返回值是partition的编号
         * */
        // 获取topic的分区列表
        List<PartitionInfo> partitionInfoList = cluster.availablePartitionsForTopic(topic);
        int partitionCount = partitionInfoList.size();
        int auditPartition = partitionCount - 1;
        return auditPartition;
    }

    /**
     * 在分区程序关闭时调用
     */
    @Override
    public void close() {
    }

    /**
     * 做必要的初始化工作
     */
    @Override
    public void configure(Map<String, ?> map) {

    }
}
