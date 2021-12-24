package com.example.java_muc2019csirrasa.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class GetPoint {
//    ak = 'rgkditHGQqDjme0T6k4KITrB3DPXajNB'
//    url = 'http://api.map.baidu.com/geocoding/v3/?address=
//    {inputAddress}&output=json&ak={myAk}'.format(inputAddress=address,myAk=ak)
    final static String AK ="rgkditHGQqDjme0T6k4KITrB3DPXajNB";
    final static String ADDRESS_TO_LONGITUDEA_URL = "http://api.map.baidu.com/geocoding/v3/?output=json";
    public static String GetPoint(String address){
        if (address==null){
            return null;
        }
        address = address.replace(" ","");
        System.out.println(address);
        String url = ADDRESS_TO_LONGITUDEA_URL+"&ak="+AK+"&address="+address;
        System.out.println(url);
        HttpClient client = HttpClients.createDefault(); // 创建默认http连接
        HttpPost post = new HttpPost(url);// 创建一个post请求
        try {
            HttpResponse response = client.execute(post);// 用http连接去执行get请求并且获得http响应
            HttpEntity entity = response.getEntity();// 从response中取到响实体
            String html = EntityUtils.toString(entity);// 把响应实体转成文本
            System.out.println("返回信息：" + html);
            // JSON转对象

            JSONObject jsonObject = JSONObject.parseObject(html);
            System.out.println(jsonObject);
            String result = jsonObject.getString("result");
            JSONObject jsonObject1 = JSONObject.parseObject(JSONObject.parseObject(result).getString("location"));
            result = jsonObject1.getString("lat") +","+ jsonObject1.getString("lng");
            return result;
        }
        catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Test
    public void test_(){
        String s = GetPoint("上海市嘉定区科贸路8号");
        System.out.println(s);
    }
}