package com.example.java_muc2019csirrasa.service;

import com.example.java_muc2019csirrasa.bean.House;

import java.util.List;

public interface Spider {
    List<House> getInsertDataList(String suggestId);
    List<House> readVsv();
    List<House> getDataFromPy(String suggestId);
}
