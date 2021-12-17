package com.example.java_muc2019csirrasa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/search")
    public String search(){
        return "index";
    }
}
