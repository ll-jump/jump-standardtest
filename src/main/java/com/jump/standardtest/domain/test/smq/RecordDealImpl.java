package com.jump.standardtest.domain.test.smq;

import com.jump.standard.commons.smq.clients.producer.RecordDeal;
import com.jump.standard.commons.smq.clients.producer.bo.ProducerRecord;
import com.jump.standard.commons.smq.clients.producer.bo.RecordDealResult;
import com.jump.standard.commons.smq.clients.producer.enums.DealResult;
import com.jump.standard.commons.smq.clients.producer.exceptions.RetrieableException;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LiLin
 * @desc 消息处理接口实现类
 * @create 2021-06-08 20:17
 **/
@Service
public class RecordDealImpl implements RecordDeal {
    private AtomicInteger count = new AtomicInteger(0);
    @Override
    public RecordDealResult deal(ProducerRecord producerRecord) {
        System.out.println("处理消息开始 key:" + producerRecord.key());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (count.getAndIncrement() <= 1){
            System.out.println("进入重试" + count.get() + ";key:" + producerRecord.key());
            //抛出此类异常会自动进行消息重试
            throw new RetrieableException("测试重试");
        }
        System.out.println(producerRecord.toString());
        RecordDealResult result = new RecordDealResult(DealResult.SUCCESS, null);
        System.out.println("处理消息结束 key:" + producerRecord.key());
        return result;
    }
}
