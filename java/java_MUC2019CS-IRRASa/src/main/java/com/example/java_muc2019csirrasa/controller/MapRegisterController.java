package com.example.java_muc2019csirrasa.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.java_muc2019csirrasa.service.MapRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class MapRegisterController {
    @Autowired
    MapRegisterService mapRegisterService;
    @PostMapping("/register")
    @ResponseBody
    public JSONObject register(String username,String password,String email){
        JSONObject json = new JSONObject();
        int register = mapRegisterService.register(username, password, email);
        if(register!=0){
            json.put("status",1);
            json.put("message","注册成功");
        }
        json.put("status",-1);
        json.put("message","注册失败");
        return null;
    }
}
