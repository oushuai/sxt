package com.bjsxt.study.spider;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author ouyangjie
 * @createTime 2019-11-26 15:09
 */
public class TestGet extends TestPost{
    public static void main(String[] args) {
        get("http://news.sina.com.cn/o/2019-11-26/doc-iihnzahi3365122.shtml");
    }
    
    public static String get(String url){
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpGet httpGet=new HttpGet(url);
        HttpResponse response= null;
        try {
            response = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity=response.getEntity();
        String content= null;
        try {
            content = EntityUtils.toString(entity,"utf-8");
           // String object=JSONObject.parse(content).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}
