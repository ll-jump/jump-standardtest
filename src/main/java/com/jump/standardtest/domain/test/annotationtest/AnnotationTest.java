package com.jump.standardtest.domain.test.annotationtest;

import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * @author LiLin
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Service
public @interface AnnotationTest {
    String value();
}
