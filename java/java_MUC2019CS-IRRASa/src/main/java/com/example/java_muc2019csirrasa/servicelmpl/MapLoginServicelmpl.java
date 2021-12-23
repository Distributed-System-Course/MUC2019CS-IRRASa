package com.example.java_muc2019csirrasa.servicelmpl;

import com.example.java_muc2019csirrasa.bean.Login;
import com.example.java_muc2019csirrasa.dao.MapLoginDao;
import com.example.java_muc2019csirrasa.service.MapLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapLoginServicelmpl implements MapLoginService {
    @Autowired
    MapLoginDao mapLoginDao;
    @Override
    public List<Login> loginAccount(String username, String password) {
        return mapLoginDao.loginAccount(username,password);
    }
}
