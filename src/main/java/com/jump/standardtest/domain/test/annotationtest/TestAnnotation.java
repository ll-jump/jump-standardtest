package com.jump.standardtest.domain.test.annotationtest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanExpressionContext;
import org.springframework.beans.factory.config.BeanExpressionResolver;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.expression.StandardBeanExpressionResolver;
import org.springframework.core.annotation.AnnotationUtils;

import java.io.Serializable;

/**
 * 〈自定义注解测试module〉
 *
 * @author LiLin
 * @date 2020/7/9 0009
 */
@AnnotationTest(value = "${annotation.test}")
public class TestAnnotation {
    @Autowired
    private ApplicationContext applicationContext;
    public String getAnnotationTestValue(){
        AnnotationTest annotationTest = AnnotationUtils.findAnnotation(this.getClass(), AnnotationTest.class);
        String value = annotationTest.value();
        System.out.println(value);
        String value2 = resolveTopic(annotationTest);
        System.out.println(value2);
        return value2;
    }

    /**
     * 解析定义的表达式 根据表达式获取配置文件的配置值
     * @param annotation
     * @return
     */
    private String resolveTopic(AnnotationTest annotation) {
        String expression = annotation.value();
        Object value = this.resolveExpression(expression);
        return (String)value;
    }

    private Object resolveExpression(String value) {
        ConfigurableApplicationContext context = (ConfigurableApplicationContext)this.applicationContext;
        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry)context.getBeanFactory();
        BeanExpressionResolver resolver = ((ConfigurableListableBeanFactory)beanFactory).getBeanExpressionResolver();
        BeanExpressionContext expressionContext = new BeanExpressionContext((ConfigurableListableBeanFactory)beanFactory, (Scope)null);
        return resolver.evaluate(this.resolve(beanFactory,value), expressionContext);
    }

    private String resolve(BeanDefinitionRegistry beanFactory, String value) {
        return beanFactory != null && beanFactory instanceof ConfigurableBeanFactory ? ((ConfigurableBeanFactory)beanFactory).resolveEmbeddedValue(value) : value;
    }
}