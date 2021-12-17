package com.example.java_muc2019csirrasa.servicelmpl;

import com.example.java_muc2019csirrasa.bean.House;
import com.example.java_muc2019csirrasa.dao.MapInsertDao;
import com.example.java_muc2019csirrasa.service.MapInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MapInsertServicelmpl implements MapInsertService {
    @Autowired
    MapInsertDao mapInsertDao;
    @Override
    public int insertResult(List<House> dataList) {
        return mapInsertDao.insertResult(dataList);
    }
}
