package com.jump.standardtest.domain.test.kafkatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

/**
 * 〈kafka生产者〉
 *
 * @author LiLin
 * @date 2020/7/15 0015
 */
//@Service
public class KafkaProducer {
//        @Autowired
//        KafkaTemplate<byte[], byte[]> kafkaTemplate;
//        public void send(String topic, String key, String value){
//            ListenableFuture<SendResult<byte[], byte[]>>
//                listenableFuture = kafkaTemplate.send(topic, key.getBytes(StandardCharsets.UTF_8), value.getBytes(StandardCharsets.UTF_8));
//            kafkaTemplate.flush();
//            SendResult<byte[], byte[]> sendResult = null;
//            try {
//                sendResult = listenableFuture.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//            System.out.println(String.format("sendResult: RecordMetadata:%s;ProducerRecord:%s", sendResult.getRecordMetadata().toString(),sendResult.getProducerRecord().toString()));
//        }
}