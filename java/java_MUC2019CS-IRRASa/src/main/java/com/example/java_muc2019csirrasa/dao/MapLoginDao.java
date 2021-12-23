package com.example.java_muc2019csirrasa.dao;

import com.example.java_muc2019csirrasa.bean.Login;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MapLoginDao {
    List<Login> loginAccount(String username, String password);
}
