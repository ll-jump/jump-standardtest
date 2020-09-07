package com.jump.standardtest.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈Redisson 引用redisson-spring-boot-starter时不需要定义该bean〉
 *
 * @author LiLin
 * @date 2020/8/27 0027
 */
@Configuration
public class RedissonConfig {
//    @Bean
//    public RedissonClient getRedissonClient(){
//        Config config = new Config();
//        config.useClusterServers()
//            // 集群状态扫描间隔时间，单位是毫秒
//            .setScanInterval(2000)
//            //可以用"rediss://"来启用SSL连接
//            .addNodeAddress("redis://10.177.97.32:6379", "redis://10.177.97.33:6379","redis://10.177.97.34:6379")
//            .addNodeAddress("redis://10.177.97.35:6379","redis://10.177.97.36:6379","redis://10.177.97.37:6379");
//        RedissonClient redisson = Redisson.create(config);
//        return redisson;
//    }
}