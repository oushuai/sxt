package com.bjsxt.study.spider;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ouyangjie
 * @createTime 2019-11-26 16:05
 */
public  class TestPost {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();

    }
    public static String post(String url, Map<String,String> param){
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpPost httpPost=new HttpPost(url);
        HttpResponse response= null;
        try {
            response = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity=response.getEntity();
        String content = null;
        try {
            content = EntityUtils.toString(entity,"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
