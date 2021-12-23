package com.example.java_muc2019csirrasa.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.java_muc2019csirrasa.bean.House;
import com.example.java_muc2019csirrasa.bean.UserSearch;
import com.example.java_muc2019csirrasa.service.MapSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MapSearchController {
    public String mapSearch(){
        return "index";
    }
    @Autowired
    MapSearchService mapSearchService;
    @PostMapping("/search")
    @ResponseBody
    public JSONObject getSearch(@RequestParam(value = "f", required = false)String f, @RequestParam(value="g", required = false)
            String g,@RequestParam(value = "suggestId", required = false) String suggestId){
        System.out.println("**********************************你好");
        List<House> search = this.mapSearchService.getSearch(suggestId);
        JSONObject json = new JSONObject();
        if (search==null || search.size()<1){
            json.put("message","数据库暂无数据,正在爬取中......");
            json.put("status",-1);
            json.put("len",0);
            return json;
        }
        json.put("len",1);
        json.put("message","查询成功");
        json.put("status",0);
        json.put("result",search);
        System.out.println(search);
        System.out.println(json);
//        json.put("message",1);
//        json.put("status",1);
//        System.out.println(f+g+suggestId);
//        json.put("f",123);
//        json.put("g",456);
//        System.out.println("******************hello**************");
        return json;
    }
    @PostMapping("/user_search")
    @ResponseBody
    public JSONObject userSearch(){
        JSONObject jsonObject = new JSONObject();
        List<UserSearch> userSearch = mapSearchService.getUserSearch();
        if (userSearch == null) {
            jsonObject.put("status",-1);
            return jsonObject;
        }
        System.out.println(userSearch.get(0));

        jsonObject.put("status",1);
        jsonObject.put("result",userSearch);
        return jsonObject;
    }

    @PostMapping("/house_search")
    @ResponseBody
    public JSONObject houseSearch(){
        JSONObject jsonObject = new JSONObject();
        List<House> userSearch = mapSearchService.getHouserSearch();
        if (userSearch == null) {
            jsonObject.put("status",-1);
            return jsonObject;
        }
        jsonObject.put("status",1);
        userSearch.remove(0);
        jsonObject.put("result",userSearch);
        System.out.println(jsonObject);
        return jsonObject;
    }
}
