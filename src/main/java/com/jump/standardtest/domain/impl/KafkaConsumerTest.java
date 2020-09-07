package com.jump.standardtest.domain.impl;

//import com.jump.standard.kafka.consumer.ConsumerRecordMetadata;
//import com.jump.standard.kafka.consumer.ConsumerRecordMetadataAware;
//import com.jump.standard.kafka.consumer.KafkaConsumerProcessor;
//import com.jump.standard.kafka.consumer.annotation.KafkaConsumer;
import com.jump.standard.kafka.consumer.ConsumerRecordMetadata;
import com.jump.standard.kafka.consumer.ConsumerRecordMetadataAware;
import com.jump.standard.kafka.consumer.KafkaConsumerProcessor;
import com.jump.standard.kafka.consumer.annotation.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

/**
 * 〈框架kafka消费者测试〉
 *
 * @author LiLin
 * @date 2020/7/17 0017
 */
@KafkaConsumer(topic = "${spring.kafka.topic.total}")
public class KafkaConsumerTest implements KafkaConsumerProcessor, ConsumerRecordMetadataAware {
    private ConsumerRecordMetadata consumerRecordMetadata;
    @Override
    public void setConsumerRecordMetadata(ConsumerRecordMetadata consumerRecordMetadata) {
        this.consumerRecordMetadata = consumerRecordMetadata;
    }

    @Override
    public void doProcess(String topic, byte[] key, byte[] value) {
        System.out.println("doProcess topic:"+topic + ";key:"+ new String(key) + ";value:" + new String(value));
    }

    @Override
    public boolean filter(ConsumerRecord<byte[], byte[]> consumerRecord){
        return false;
    }
}