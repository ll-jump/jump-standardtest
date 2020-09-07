package com.jump.standardtest.domain.impl;

import com.jump.standard.httpclient.service.impl.HttpClientServiceImpl;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 〈httpclient扩展类〉
 *
 * @author LiLin
 * @date 2020/7/1 0001
 */
@Service(value = "httpClientEx")
public class HttpClientEx extends HttpClientServiceImpl {
    @Autowired
    private CloseableHttpClient closeableHttpClient;

    public String postJsonA(String url, Map<String, Object> param) {
        return postJson(url, param, null);
    }
}