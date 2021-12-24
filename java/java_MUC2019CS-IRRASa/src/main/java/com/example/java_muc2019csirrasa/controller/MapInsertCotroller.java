package com.example.java_muc2019csirrasa.controller;

import com.example.java_muc2019csirrasa.bean.House;
import com.example.java_muc2019csirrasa.service.MapInsertService;
import com.example.java_muc2019csirrasa.service.Spider;
import com.example.java_muc2019csirrasa.servicelmpl.Spiderlmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")

public class MapInsertCotroller {
    @Autowired
    Spider spider;
    @Autowired
    MapInsertService mapInsertService;
    @PostMapping("/insert")
    @ResponseBody
    public void insertCotroller(@RequestParam(value = "suggestId", required = false) String suggestId){
        List<House> dataList = spider.getInsertDataList(suggestId);
        System.out.println(dataList);
        int status = mapInsertService.insertResult(dataList);
        System.out.println(dataList);
    }
}
