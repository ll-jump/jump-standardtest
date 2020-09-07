package com.jump.standardtest.domain.test.kafkatest;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 〈kafka消费者〉
 *
 * @author LiLin
 * @date 2020/7/15 0015
 */
//@Component
public class KafkaConsumer {
        @KafkaListener(id = "testConsumerC", topics = "test_kafka_jump_d", containerFactory="kafkaListenerContainerFactory",autoStartup = "true")
        public void listenTest(ConsumerRecord<byte[], byte[]> msg){
            System.out.println("listenTest:" + msg.toString());
        }
}