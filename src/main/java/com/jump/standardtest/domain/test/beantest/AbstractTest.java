package com.jump.standardtest.domain.test.beantest;

/**
 * 〈〉
 *
 * @author LiLin
 * @date 2020/7/2 0002
 */
public abstract class AbstractTest implements TestA {
    private String a;
    public void setA(String a){
        this.a = a;
    }
    public String getA(){
        return this.a;
    }
}