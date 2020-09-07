package com.jump.standardtest.domain.impl;

import com.jump.standard.commons.snowflake.SnowflakeGenerator;
import com.jump.standard.httpclient.service.HttpClientService;
import com.jump.standard.kafka.producer.KafkaProducer;
import com.jump.standard.kafka.producer.ProducerResult;
import com.jump.standard.redis.service.impl.JedisClient;
import com.jump.standardtest.bo.RedisTestBO;
import com.jump.standardtest.domain.TestFrameworkService;
import com.jump.standardtest.domain.test.beantest.OutC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * 〈〉
 *
 * @author LiLin
 * @date 2020/7/1 0001
 */
@Service
public class TestFrameworkFrameworkServiceImpl implements TestFrameworkService {

    //        @Autowired
    //    private HttpClientService httpClientService;
    //如果自己项目重新实现了HttpClientService，则走自定义的；如果自己未实现HttpClientService，则走框架默认bean
    @Autowired
    private HttpClientService httpClientService;

    @Autowired
    OutC.AbstractTestImpl abstractTest;
    @Autowired
    JedisClient jedisClient;
    //    @Autowired
    //    private KafkaTemplate<byte[], byte[]> kafkaTemplate;
    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private SnowflakeGenerator snowflakeGenerator;

    @Override
    public String testHttpClient() {
        jedisClient.set("aa", "aav");
        System.out.println(abstractTest.getA());
        String res0 = httpClientService.postJson("https://www.baidu.com/", null);
        System.out.println("0:" + res0);
        String res = httpClientService.postJson("https://www.baidu.com/", null);
        System.out.println("1:" + res);
        String res2 = ((HttpClientEx)httpClientService).postJsonA("https://www.baidu.com/", null);
        System.out.println("2:" + res2);
        return res0;
    }

    @Override
    public String testJedis() {
        RedisTestBO redisTestBO = new RedisTestBO();
        redisTestBO.setKey("testA");
        redisTestBO.setValue("阿巴拉");
        jedisClient.set("test-a", redisTestBO, 100);
        RedisTestBO r = jedisClient.get("test-a", RedisTestBO.class);
        return r.toString();
    }

    @Override
    public void testKafka() {
        try {
            ProducerResult producerResult = kafkaProducer.syncSend("test_kafka_jump_d", "key" + UUID.randomUUID().toString().replace("-", ""),
                    "value" + UUID.randomUUID().toString());
            System.out.println(producerResult.topic() + ";" + new String(producerResult.key()) + ";" + new String(
                producerResult.value()));
            System.out.println(producerResult.offset() + ";" + producerResult.partition());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testSnowflake() {
        String id = String.valueOf(snowflakeGenerator.nextId());
        System.out.println(id);
    }

    @Override
    public String testRedisLock() {
        boolean lock = jedisClient.lock("1","1", 60, 10L);
        System.out.println("thread1"+ lock);
        System.out.println("thread1"+jedisClient.getString("1"));
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 start.");
                boolean lock = jedisClient.lock("1","2", 60, 30L);
                System.out.println("thread2 lock:" + lock);
                System.out.println("thread2:"+jedisClient.getString("1"));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (lock){
                    String r = jedisClient.unlock("1","2");
                    System.out.println("thread2 unlock:" + r);
                }

            }
        });
        thread.start();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       String r = jedisClient.unlock("1","1");
        System.out.println(r);
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}