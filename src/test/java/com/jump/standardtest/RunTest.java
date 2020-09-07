package com.jump.standardtest;

import com.jump.standardtest.domain.TestFrameworkService;
import com.jump.standardtest.domain.test.redis.RedisTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 〈〉
 *
 * @author LiLin
 * @date 2020/8/27 0027
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class RunTest {
    @Autowired
    private TestFrameworkService testFrameworkService;
    @Autowired
    private RedisTest redisTest;
    @Test
    public void testRedisson(){
        try {
            redisTest.testRedissonClient();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testRedisLock(){
        testFrameworkService.testRedisLock();
    }

    @Test
    public void testRedisTemplate(){
        redisTest.testRedisTemplate();
    }
    @Test
    public void testRedissonBlocking(){
        redisTest.testRedissonBlocking();
    }
}