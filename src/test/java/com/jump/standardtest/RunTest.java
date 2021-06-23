package com.jump.standardtest;

import com.jump.standardtest.domain.TestFrameworkService;
import com.jump.standardtest.domain.test.smq.SmqTest;
import com.jump.standardtest.domain.test.smq.SmqTest2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;

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
    //    @Autowired
//    private RedisTest redisTest;
    @Autowired
    private SmqTest smqTest;
    @Autowired
    private SmqTest2 smqTest2;

    @Test
    public void testQueue() throws InterruptedException {
        LinkedBlockingQueue<String> records = new LinkedBlockingQueue<>();
        records.add("a");
        String s = records.poll();
        System.out.println(s);
        String s1 = records.take();
        System.out.println(s1);
        records.add("b");

        s1 = records.poll();
        System.out.println(s1);
        Thread.sleep(10000);
        System.out.println("end");
    }

    @Test
    public void testSmq() {
        try {
            System.out.println("发送消息开始");
            //单条测试
            smqTest.testSmq(true);
            //消息顺序处理测试
//            for (int i = 0; i < 10; i++) {
//                smqTest.testSmq(false);
//            }

            //并发测试
//            for (int i = 0; i < 10; i++) {
//                Thread thread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            smqTest.testSmq(true);
//                        } catch (ExecutionException e) {
//                            e.printStackTrace();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//                thread.start();
//            }
            System.out.println("发送消息结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRedisson() {
//        try {
//            redisTest.testRedissonClient();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testRedisLock() {
        testFrameworkService.testRedisLock();
    }

    @Test
    public void testRedisTemplate() {
//        redisTest.testRedisTemplate();
    }

    @Test
    public void testRedissonBlocking() {
//        redisTest.testRedissonBlocking();
    }
}