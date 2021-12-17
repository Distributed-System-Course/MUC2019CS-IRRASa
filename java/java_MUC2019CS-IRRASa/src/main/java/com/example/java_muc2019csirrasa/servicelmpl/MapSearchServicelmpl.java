package com.example.java_muc2019csirrasa.servicelmpl;

import com.example.java_muc2019csirrasa.bean.House;
import com.example.java_muc2019csirrasa.dao.MapSearchDao;
import com.example.java_muc2019csirrasa.service.MapSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapSearchServicelmpl implements MapSearchService {
    @Autowired
    MapSearchDao mapSearchDao;
    @Override
    public List<House> getSearch(String suggestId) {
        return mapSearchDao.searchResult(suggestId);
    }
}
