package com.example.java_muc2019csirrasa.service;

import com.example.java_muc2019csirrasa.bean.House;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface MapSearchService {
    List<House> getSearch(String suggestId);
}
