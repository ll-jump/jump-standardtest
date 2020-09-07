package com.jump.standardtest.domain.test.kafkatest.config;

import com.jump.standardtest.domain.test.kafkatest.KafkaConsumer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

/**
 * 〈kafka bean〉
 *
 * @author LiLin
 * @date 2020/7/16 0016
 */
//@Configuration
//@EnableKafka
public class KafkaConfig {

//        @Bean
//        KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<byte[], byte[]>> kafkaListenerContainerFactory(@Qualifier("kafkaConsumerFactory")
//            ConsumerFactory<byte[], byte[]> consumerFactory) {
//            ConcurrentKafkaListenerContainerFactory<byte[], byte[]> factory = new ConcurrentKafkaListenerContainerFactory<>();
//            factory.setConsumerFactory(consumerFactory);
//            factory.setConcurrency(3);
//            factory.getContainerProperties().setPollTimeout(3000);
//            return factory;
//        }

}