package com.example.java_muc2019csirrasa.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.java_muc2019csirrasa.utils.GetPoint;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class Search {
    @ResponseBody
    @PostMapping("/point")
    public JSONObject search(String startPoint,String endPoint){
        JSONObject jsonObject = new JSONObject();
        String getPoint = GetPoint.GetPoint(startPoint);
        String getPoint1 = GetPoint.GetPoint(endPoint);
        System.out.println("getpoint="+getPoint);
        System.out.println("getpoint1="+getPoint1);
        if (getPoint!=null) {
            jsonObject.put("result",getPoint);
            jsonObject.put("result1",getPoint1);
            jsonObject.put("status",1);
            return jsonObject;
        }
        jsonObject.put("status",-1);
        return jsonObject;
    }
    @Test
    public void test1(){
        search("上海市嘉定区科贸路8号","2wer");
    }
}
