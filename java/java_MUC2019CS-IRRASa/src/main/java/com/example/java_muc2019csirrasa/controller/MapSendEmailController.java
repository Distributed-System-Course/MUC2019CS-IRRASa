package com.example.java_muc2019csirrasa.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.example.java_muc2019csirrasa.utils.Email.achieveCode;
import static com.example.java_muc2019csirrasa.utils.Email.sendAuthCodeEmail;

@Controller
@RequestMapping("/")
public class MapSendEmailController {
    @ResponseBody
    @PostMapping("/email")
    public JSONObject sendEmail(String email){
        JSONObject json= new JSONObject();
        String code = achieveCode();
        int status=sendAuthCodeEmail(email,code);
        json.put("code",code);
        json.put("status",status);
        return json;
    }
}
