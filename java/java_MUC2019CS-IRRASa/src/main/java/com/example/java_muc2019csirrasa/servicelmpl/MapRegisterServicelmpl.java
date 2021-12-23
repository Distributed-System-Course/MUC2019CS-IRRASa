package com.example.java_muc2019csirrasa.servicelmpl;

import com.example.java_muc2019csirrasa.dao.MapRegisterDao;
import com.example.java_muc2019csirrasa.service.MapRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapRegisterServicelmpl implements MapRegisterService {
    @Autowired MapRegisterDao mapRegisterDao;

    @Override
    public int register(String username,String password,String email) {
        return mapRegisterDao.register(username,password,email);
    }
}
