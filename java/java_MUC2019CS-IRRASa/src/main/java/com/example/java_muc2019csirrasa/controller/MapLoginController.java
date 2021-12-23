package com.example.java_muc2019csirrasa.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.java_muc2019csirrasa.bean.Login;
import com.example.java_muc2019csirrasa.service.MapLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class MapLoginController {
    @Autowired
    MapLoginService mapLoginService;
    @PostMapping("/login")
    @ResponseBody
    public JSONObject login(String username,String password){
        JSONObject json = new JSONObject();
        List<Login> account = mapLoginService.loginAccount(username, password);
        if (account==null || account.size()<1){
            json.put("message","未查询到该账号");
            json.put("status",-1);
            return json;
        }
        json.put("message","查询成功");
        json.put("status",1);
        return json;
    }
}
