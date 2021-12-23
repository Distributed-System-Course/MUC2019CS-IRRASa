package com.example.java_muc2019csirrasa.service;

import com.example.java_muc2019csirrasa.bean.Login;

import java.util.List;

public interface MapLoginService {
    List<Login> loginAccount(String username, String password);
}
