package com.example.client.controller;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class test {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/test")
    public String test1(){
        String object = restTemplate.getForObject("http://10.151.25.134:8080/test", String.class);
        return object;
    }
}
