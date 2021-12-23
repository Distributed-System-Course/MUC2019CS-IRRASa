package com.example.java_muc2019csirrasa.controller;

import org.springframework.stereotype.Controller;
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
    @RequestMapping("/admin")
    public String admin(){
        return "admin/back_index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/login.html")
    public String login1(){
        return "login";
    }
    @RequestMapping("/register.html")
    public String register(){
        return "register";
    }
    @RequestMapping("/register")
    public String register1(){
        return "register";
    }
    @RequestMapping("/house_info.html")
    public String houseInfo(){
        return "admin/house_info";
    }
    @RequestMapping("/admin/house_info.html")
    public String houseInfo1(){
        return "admin/house_info";
    }
    @RequestMapping("/admin/house_inf")
    public String houseInfo2(){
        return "admin/house_info";
    }
    @RequestMapping("/search_info.html")
    public String searchInfo(){
        return "admin/search_info";
    }
    @RequestMapping("/admin/search_info.html")
    public String searchInfo1(){
        return "admin/search_info";
    }

    @RequestMapping("/user_info.html")
    public String userInfo(){
        return "admin/user_info";
    }
    @RequestMapping("/admin/user_info.html")
    public String userInfo1(){
        return "admin/user_info";
    }

}
