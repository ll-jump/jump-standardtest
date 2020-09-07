package com.jump.standardtest.domain.test.beantest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 〈bean初始化测试〉
 *
 * @author LiLin
 * @date 2020/7/9 0009
 */
@Service
public class TestBeanInit implements InitializingBean {
    @Value("${annotation.test}")
    private String value;
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("TestBeanInit afterPropertiesSet annotation.test:" + value);
    }
}