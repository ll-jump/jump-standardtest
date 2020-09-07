package com.jump.standardtest.domain.test.annotationtest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.config.BeanExpressionContext;
import org.springframework.beans.factory.config.BeanExpressionResolver;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.context.expression.StandardBeanExpressionResolver;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

/**
 * 〈自定义注解AnnotationTest初始化bean处理〉
 *
 * @author LiLin
 * @date 2020/7/9 0009
 */
@Component
public class ATestAnnotationBeanPostProcessor implements BeanPostProcessor, BeanFactoryAware{
    private BeanFactory beanFactory;
    private BeanExpressionContext expressionContext;
    private BeanExpressionResolver resolver = new StandardBeanExpressionResolver();

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        if (beanFactory instanceof ConfigurableListableBeanFactory) {
            this.resolver = ((ConfigurableListableBeanFactory)beanFactory).getBeanExpressionResolver();
            this.expressionContext = new BeanExpressionContext((ConfigurableListableBeanFactory)beanFactory, (Scope)null);
        }
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        AnnotationTest ann = AnnotationUtils.findAnnotation(bean.getClass(), AnnotationTest.class);
        if (ann != null) {
            //解析定义的表达式 根据表达式获取配置文件的配置值
            String value = this.resolveTopic(ann);
            System.out.println("自定义注解AnnotationTestvalue="+ value);
        }

        return bean;
    }

    private String resolveTopic(AnnotationTest annotation) {
        String expression = annotation.value();
        Object value = this.resolveExpression(expression);
        return (String)value;
    }

    private Object resolveExpression(String value) {
        return this.resolver.evaluate(this.resolve(value), this.expressionContext);
    }

    private String resolve(String value) {
        return this.beanFactory != null && this.beanFactory instanceof ConfigurableBeanFactory ? ((ConfigurableBeanFactory)this.beanFactory).resolveEmbeddedValue(value) : value;
    }

}