package com.jump.standardtest.config;

import java.util.Map;

import com.jump.standard.commons.snowflake.SnowflakeGenerator;
import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;import org.apache.dubbo.common.utils.NetUtils;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 唯一id生成器
 * 
 * @author LiLin
 * @date 2019/09/24
 * @version 1.0.0
 */
@Configuration
public class SnowflakeGeneratorConfig {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SnowflakeGeneratorConfig.class);
    
    @Value("${snowflake.defalut-worker-id}")
    private long defalutWorkerId;
    
    @Value("#{${snowflake.worker-id-map}}")
    private Map<String, Long> workerIdMap;

    @Bean(name = "snowflakeGenerator")
    public SnowflakeGenerator getSnowflakeGenerator() {
        long workerId = defalutWorkerId;
//        String ip = NetUtils.getLocalHost();
//        if (workerIdMap.containsKey(ip)) {
//            workerId = workerIdMap.get(ip);
//        }
        workerId = 0L;
//        LOGGER.info("service ip:【{}】,snowflake workerId:【{}】", ip, workerId);
        SnowflakeGenerator.setWorkerId(workerId);
        SnowflakeGenerator generator = new SnowflakeGenerator();
        return generator;
    }

}
