package com.jump.standardtest.controller;

import com.jump.standard.core.result.ServiceResult;
import com.jump.standard.kafka.producer.KafkaProducer;
import com.jump.standardtest.domain.TestFrameworkService;
import com.jump.standardtest.domain.test.annotationtest.TestAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 〈测试〉
 *
 * @author LiLin
 * @create 2019/7/10 0010
 */
@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private TestFrameworkService testService;
    @Autowired
    private TestAnnotation testAnnotation;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private KafkaProducer kafkaProducer;
    @RequestMapping(value = "/httpClient", method = RequestMethod.POST)
    public ServiceResult<String> testHttp() {
         String res = testService.testHttpClient();
         return ServiceResult.success(res);
    }

    @RequestMapping(value = "/testJedis", method = RequestMethod.POST)
    public ServiceResult<String> testJedis() {
        String res = testService.testJedis();
        return ServiceResult.success(res);
    }

    @RequestMapping(value = "/testAnnotation", method = RequestMethod.POST)
    public ServiceResult<String> testAnnotation() {
        String res = testAnnotation.getAnnotationTestValue();
        return ServiceResult.success(res);
    }

    @RequestMapping(value = "/testKafka", method = RequestMethod.POST)
    public ServiceResult<String> testKafka() {
//        String value = UUID.randomUUID().toString();
//        kafkaProducer.send("test_kafka_jump_d", "test-" + UUID.randomUUID().toString().replace("-",""), value);
        return ServiceResult.success(null);
    }

    @RequestMapping(value = "/testKafkaFw", method = RequestMethod.POST)
    public ServiceResult<String> testKafkaFw() {
       testService.testKafka();
        return ServiceResult.success(null);
    }

    @RequestMapping(value = "/testSnowflake", method = RequestMethod.POST)
    public ServiceResult<String> testSnowflake() {
        testService.testSnowflake();
        return ServiceResult.success(null);
    }
}
