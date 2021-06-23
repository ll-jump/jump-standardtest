package com.jump.standardtest.domain.test.smq;

import com.jump.standard.commons.smq.clients.producer.CallBack;
import com.jump.standard.commons.smq.clients.producer.RecordDeal;
import com.jump.standard.commons.smq.clients.producer.SmqProducer;
import com.jump.standard.commons.smq.clients.producer.bo.ProducerRecord;
import com.jump.standard.commons.smq.clients.producer.bo.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author LiLin
 * @desc smq测试类
 * @create 2021-06-08 20:03
 **/
@Service
public class SmqTest2 {
    @Autowired
    private SmqProducer smqProducer;
    @Autowired
    private RecordDeal recordDeal;

    public void testSmq() throws ExecutionException, InterruptedException {
        String key = UUID.randomUUID().toString();
        ProducerRecord producerRecord = new ProducerRecord("group_1", key);
        Future<RecordMetadata> recordMetadataFuture = smqProducer.send(producerRecord, recordDeal, new CallBack() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception exception) {
                System.out.println("2 消息处理结束回调方法执行开始");
                System.out.println("2 recordMetadata:" + recordMetadata.toString() + "exception:" + (exception == null ? "null" : exception.getMessage()));
                System.out.println("2 消息处理结束回调方法执行结束");
            }
        });

        System.out.println("2 主线程获取消息处理结果");
        RecordMetadata recordMetadata = recordMetadataFuture.get();
        System.out.println("2 主线程获取到了消息处理结果：RecordMetadata：" + recordMetadata.toString());
        Thread.sleep(10000);
    }
}
