package com.example.java_muc2019csirrasa.utils;
import com.csvreader.CsvReader;
import org.junit.Test;
import com.example.java_muc2019csirrasa.bean.House;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

import java.util.LinkedList;
import java.util.List;


public class Spider {
    public static List<House> getInsertDataList(String suggestId){
        return getDataFromPy(suggestId);
    }
    private static List<House> readVsv(){
        List<House> dataList = new LinkedList<>();
        House house;
        try {
            CsvReader csvReader = new CsvReader("src/main/java/com/example/java_muc2019csirrasa/python/data.csv", ',', StandardCharsets.UTF_8);
            csvReader.readHeaders();
            while (csvReader.readRecord()) {
                house = new House(csvReader.get("sourcePrompt"),csvReader.get("houseName"),
                        csvReader.get("houseArea"),csvReader.get("housePrice"),
                        csvReader.get("houseType"),csvReader.get("houseLocation"));
                dataList.add(house);
            }
            return dataList;
        }
       catch (Exception e){
            e.printStackTrace();
       }
      return Collections.emptyList();
    }
    private static List<House> getDataFromPy(String suggestId){
        String[] s = new String[]{"python", "src/main/java/com/example/java_muc2019csirrasa/python/anjuke.py", suggestId};
        try {
            Process process = Runtime.getRuntime().exec(s);
            if (process.waitFor()!=0){
               return Collections.emptyList();
           }
            return readVsv();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    @Test
    public void test1(){
        List<House> dataFromPy = getDataFromPy("中央民族大学");
        System.out.println(dataFromPy);
//        readVsv("src/main/java/com/example/java_muc2019csirrasa/python/data.csv");
    }
}
