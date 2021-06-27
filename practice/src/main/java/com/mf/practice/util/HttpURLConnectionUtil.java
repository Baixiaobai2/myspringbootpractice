package com.mf.practice.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionUtil {

    //原生httpGet请求方式
    public static String doGet(String urlStr){
        HttpURLConnection conn = null;

        InputStream is = null;
        BufferedReader br = null;

        StringBuilder result = new StringBuilder();

        try {
            // 创建远程url的连接对象
            URL url = new URL(urlStr);
            // 通过链接对象打开连接
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            // 连接超时时间   读取超时时间
            // 连接时间  从发送请求开始  到连接到主机地址的时间
            // 读取时间  连接成功后 进行内容数据获取的时间
            conn.setConnectTimeout(15000);
            conn.setReadTimeout(60000);
            //设置读取返回数据格式
            conn.setRequestProperty("Accept","application/json");
            // 发送请求
            conn.connect();

            // 识别返回码
            if(200 == conn.getResponseCode()){
                is = conn.getInputStream();
                br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                String line;
                while ((line = br.readLine())!=null){
                    result.append(line);
                }
            }else{
                System.out.println("返回了错误码："+conn.getResponseCode());
            }

        }catch (Exception e){

        }finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (is != null) {
                    is.close();
                }
            }catch (Exception e){}

            // 关闭连接
            conn.disconnect();
        }

        return result.toString();
    }

}
