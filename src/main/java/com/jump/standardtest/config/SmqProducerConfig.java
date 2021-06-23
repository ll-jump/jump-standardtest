package com.jump.standardtest.config;

import com.jump.standard.commons.smq.clients.producer.SmqProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author LiLin
 * @desc
 * @create 2021-06-09 10:32
 **/
@Configuration
public class SmqProducerConfig {
    @Bean
    public SmqProducer smqProducer(){
        Properties props = new Properties();
        //客户端id
        props.put("client.id", "1");
        //最大重试次数
        props.put("retry.max.times", 1);
        //重试间隔
        props.put("retry.interval", 10000);
        /**
         * 消息处理是否强制按顺序，默认为false（false时消息正常处理为顺序处理，但是重试消息优先级低于正常消息；true时，严格按照顺序处理，重试消息优先级高于正常消息）
         * 此属性需谨慎配置，如果业务不是必须严格顺序处理，不建议配置该属性为true，因为配置后，重试消息会阻塞重试间隔时间，导致之后发送的正常消息也被阻塞了
         */
        props.put("strong.in.order", false);
        SmqProducer smqProducer = new SmqProducer(props);
        return smqProducer;
    }
}
