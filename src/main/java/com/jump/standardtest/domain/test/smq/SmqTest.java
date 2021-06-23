package com.jump.standardtest.domain.test.smq;

import com.jump.standard.commons.smq.clients.producer.CallBack;
import com.jump.standard.commons.smq.clients.producer.RecordDeal;
import com.jump.standard.commons.smq.clients.producer.SmqProducer;
import com.jump.standard.commons.smq.clients.producer.bo.ProducerRecord;
import com.jump.standard.commons.smq.clients.producer.bo.RecordMetadata;
import com.jump.standardtest.bo.RedisTestBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LiLin
 * @desc smq测试类
 * @create 2021-06-08 20:03
 **/
@Service
public class SmqTest {
    @Autowired
    private SmqProducer smqProducer;
    @Autowired
    private RecordDeal recordDeal;
    private AtomicInteger count = new AtomicInteger(0);

    public void testSmq(boolean waitResult) throws ExecutionException, InterruptedException {
        int key = count.getAndIncrement();
        RedisTestBO redisTestBO = new RedisTestBO();
        redisTestBO.setKey("key" + key);
        redisTestBO.setValue("我是消息内容");
        final ProducerRecord producerRecord = new ProducerRecord("group_1", String.valueOf(key), redisTestBO, System.currentTimeMillis());
        System.out.println("发送消息 key:" + key);
        Future<RecordMetadata> recordMetadataFuture = smqProducer.send(producerRecord, recordDeal, new CallBack() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception exception) {
                System.out.println("消息处理结束回调方法执行开始 key:" + producerRecord.key());
                System.out.println("key:" + producerRecord.key() + "回调方法参数：recordMetadata:" + recordMetadata.toString() + "exception:" + (exception == null ? "null" : exception.getMessage()));
                System.out.println("消息处理结束回调方法执行结束key:" + producerRecord.key());
            }
        });

        if (waitResult) {
            System.out.println("主线程等待获取消息处理结果 key:" + producerRecord.key());
            RecordMetadata recordMetadata = null;
            try {
                recordMetadata = recordMetadataFuture.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("主线程获取到了消息处理结果：RecordMetadata：" + (recordMetadata == null ? "null" : recordMetadata.toString()));
        }
    }

}
