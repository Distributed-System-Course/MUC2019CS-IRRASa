package com.example.java_muc2019csirrasa.servicelmpl;

import com.example.java_muc2019csirrasa.bean.House;
import com.example.java_muc2019csirrasa.bean.UserSearch;
import com.example.java_muc2019csirrasa.dao.MapSearchDao;
import com.example.java_muc2019csirrasa.service.MapInsertService;
import com.example.java_muc2019csirrasa.service.MapSearchService;
import com.example.java_muc2019csirrasa.service.Spider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapSearchServicelmpl implements MapSearchService {
    @Autowired
    Spider spider;
    @Autowired
    MapSearchDao mapSearchDao;
    @Autowired
    MapInsertService mapInsertService;
    @Override
    public List<House> getSearch(String suggestId) {
        List<House> houseList = mapSearchDao.searchResult(suggestId);
        if (houseList.size()<1){
            List<House> dataList = spider.getInsertDataList(suggestId);
            if (dataList!=null&&dataList.size()>=1) {
                System.out.println("*********666*****************" + dataList);
                int status = mapInsertService.insertResult(dataList);
            }
        }
        return mapSearchDao.searchResult(suggestId);
    }

    @Override
    public List<UserSearch> getUserSearch() {
        return mapSearchDao.getUserSearch();
    }

    @Override
    public List<House> getHouserSearch() {
        return mapSearchDao.getHouserSearch();
    }
}
