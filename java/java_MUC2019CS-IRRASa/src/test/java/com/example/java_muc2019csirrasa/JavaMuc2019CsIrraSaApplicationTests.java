package com.example.java_muc2019csirrasa;

import com.alibaba.fastjson.JSONObject;
import com.example.java_muc2019csirrasa.bean.House;
import com.example.java_muc2019csirrasa.bean.Login;
import com.example.java_muc2019csirrasa.bean.UserSearch;
import com.example.java_muc2019csirrasa.service.MapInsertService;
import com.example.java_muc2019csirrasa.service.MapLoginService;
import com.example.java_muc2019csirrasa.service.MapSearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JavaMuc2019CsIrraSaApplicationTests {
    @Autowired
    MapInsertService mapInsertService;
    @Autowired
    MapSearchService mapSearchService;
    @Test
    void contextLoads() {
        System.out.println("**********************************你好");
        List<House> search =mapSearchService.getSearch("北京市朝阳区朝阳大悦城");
        JSONObject json = new JSONObject();
//        if (search==null || search.size()<1){
//            json.put("message","数据库暂无数据,正在爬取中......");
//            json.put("status",-1);
//            List<House> dataList = Spider.getInsertDataList("北京市朝阳区朝阳大悦城");
//            System.out.println("**************************8888"+dataList);
//            int status = mapInsertService.insertResult(dataList);
//            System.out.println(dataList);
//        }
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
//        System.out.println("*****
    }
    @Autowired
    MapLoginService mapLoginService;
    @Test
    void test1(){

        JSONObject json = new JSONObject();
        List<Login> account = mapLoginService.loginAccount("wangjun", "340824");
        if (account==null || account.size()<1){
            json.put("message","未查询到该账号");
            json.put("status",-1);

        }
        json.put("message","查询成功");
        json.put("status",1);
    }
    @Test
    void test2(){
        List<UserSearch> search = mapSearchService.getUserSearch();
        System.out.println();
    }
    @Test
    void test3(){
        List<House> search = mapSearchService.getHouserSearch();
        System.out.println();
    }

}
