package com.example.java_muc2019csirrasa.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MapRegisterDao {
    int register(String username,String password,String email);
}
