package com.yh.httpclientdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yh.dto.TianQiResponseEntity;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientDemo {
    public static void main(String[] args) throws IOException {
        HttpClientDemo httpClientDemo = new HttpClientDemo();
        String url = "http://t.weather.sojson.com/api/weather/city/101030100";
        httpClientDemo.httpClientGetDemo(url);
    }

    public void httpClientGetDemo(String url) throws IOException {
        //模拟一个浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        //设置长连接
        httpGet.setHeader("Connection","keep-alive");
        //设置请求头的浏览器属性，欺骗服务器告诉它是一个浏览器向服务器发送请求
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        CloseableHttpResponse httpResponse=null;
    try{
        //执行Get请求
        httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();
        String s = EntityUtils.toString(entity);
        System.out.println(s);
        //创建对象映射类,用于转换字符串-->对象
        ObjectMapper objectMapper = new ObjectMapper();
        TianQiResponseEntity entity1 = objectMapper.readValue(s,TianQiResponseEntity.class);
        System.out.println(entity1);
    } catch (IOException e) {
        e.printStackTrace();
    }finally {
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
}
