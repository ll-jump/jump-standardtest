package com.jump.standardtest.domain.test.beantest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈测试bean创建〉
 *
 * @author LiLin
 * @date 2020/7/2 0002
 */
@Configuration
public class OutC {

    @Bean
    public AbstractTestImpl getBBBAbstractTestImpl(){
        AbstractTestImpl abstractTest = new AbstractTestImpl();
        abstractTest.setA("aaaa");
        return  abstractTest;
    }

    public class AbstractTestImpl extends AbstractTest {
        @Override
        public void getBBB() {
            System.out.println("BBBBBB");
        }
    }
}