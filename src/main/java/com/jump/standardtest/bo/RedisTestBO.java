package com.jump.standardtest.bo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * 〈〉
 *
 * @author LiLin
 * @date 2020/7/8 0008
 */
public class RedisTestBO implements Serializable {
    private static final long serialVersionUID = -1824624397082405404L;
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this);
    }
}