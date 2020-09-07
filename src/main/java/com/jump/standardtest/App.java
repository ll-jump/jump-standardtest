package com.jump.standardtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"com.jump.standardtest","com.jump.standard"},
//        excludeFilters = {@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, classes = {HttpClientServiceImpl.class})})
@ComponentScan(basePackages = {"com.jump.standardtest", "com.jump.standard"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
