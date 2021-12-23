package com.example.java_muc2019csirrasa.dao;

import com.example.java_muc2019csirrasa.bean.House;
import com.example.java_muc2019csirrasa.bean.UserSearch;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ASUS
 */
@Repository
@Mapper
public interface MapSearchDao {
    List<House> searchResult(String suggestId);
    List<UserSearch> getUserSearch();
    List<House> getHouserSearch();
}
