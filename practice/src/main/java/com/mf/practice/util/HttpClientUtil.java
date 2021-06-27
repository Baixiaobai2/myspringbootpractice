package com.mf.practice.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

    public static String doGet(String url) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;

        String result = "";

        try {
            // 通过默认配置 创建一个实例
            httpClient = HttpClients.createDefault();
            // 创建一个远程连接的实例
            HttpGet httpGet = new HttpGet(url);
            // 设置请求头
            httpGet.addHeader("Accept", "application/json");
            // 配置请求参数
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(15000) // 连接主机的超时时间
                    .setSocketTimeout(60000) // 数据读取的超时时间
                    .build();

            // 进行配置
            httpGet.setConfig(requestConfig);
            // 执行请求
            response = httpClient.execute(httpGet);

            // 接收返回数据
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (response != null) {
                    response.close();
                }

                if (httpClient != null) {
                    httpClient.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return result;
    }

}
