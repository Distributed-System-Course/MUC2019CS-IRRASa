package com.example.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;  //拉取所有的服务信息

    @GetMapping("/")
    @ResponseBody
    public String test1(){

        //可能会有多个同名服务，故使用list
        List<ServiceInstance> instances = discoveryClient.getInstances("house");
        ServiceInstance instance = instances.get(0);
//        return this.restTemplate.getForObject("http://"+instance.getHost()+":"+ instance.getPort() +"/search",String.class);
//        直接通过地址和端口调用，没有通过服务区调用
        return this.restTemplate.getForObject("http://10.151.25.134:8080" , String.class);

    }
    @GetMapping("/admin")
    @ResponseBody
    public String test2(){

        //可能会有多个同名服务，故使用list
        List<ServiceInstance> instances = discoveryClient.getInstances("house");
        ServiceInstance instance = instances.get(0);
//        return this.restTemplate.getForObject("http://"+instance.getHost()+":"+ instance.getPort() +"/search",String.class);
//        直接通过地址和端口调用，没有通过服务区调用
        return this.restTemplate.getForObject("http://10.151.25.134:8080/admin" , String.class);

    }
    @GetMapping("/login")
    @ResponseBody
    public String test3(){

        //可能会有多个同名服务，故使用list
        List<ServiceInstance> instances = discoveryClient.getInstances("house");
        ServiceInstance instance = instances.get(0);
//        return this.restTemplate.getForObject("http://"+instance.getHost()+":"+ instance.getPort() +"/search",String.class);
//        直接通过地址和端口调用，没有通过服务区调用
        return this.restTemplate.getForObject("http://10.151.25.134:8080/login" , String.class);

    }
    @GetMapping("/register")
    @ResponseBody
    public String test4(){

        //可能会有多个同名服务，故使用list
        List<ServiceInstance> instances = discoveryClient.getInstances("house");
        ServiceInstance instance = instances.get(0);
//        return this.restTemplate.getForObject("http://"+instance.getHost()+":"+ instance.getPort() +"/search",String.class);
//        直接通过地址和端口调用，没有通过服务区调用
        return this.restTemplate.getForObject("http://10.151.25.134:8080/register" , String.class);

    }



}
