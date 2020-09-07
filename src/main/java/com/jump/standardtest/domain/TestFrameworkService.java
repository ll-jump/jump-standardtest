package com.jump.standardtest.domain;

/**
 * 〈测试〉
 *
 * @author LiLin
 * @date 2020/7/1 0001
 */
public interface TestFrameworkService {
    String testHttpClient();

    String testJedis();

    void testKafka();

    /**
     * 雪花算法
     */
    void testSnowflake();

    String testRedisLock();
}
