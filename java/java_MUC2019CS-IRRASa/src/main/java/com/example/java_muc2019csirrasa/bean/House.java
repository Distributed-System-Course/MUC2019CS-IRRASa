package com.example.java_muc2019csirrasa.bean;

import org.springframework.context.annotation.Bean;


public class House {
//    String uid;
    String sourcePrompt;
    String houseName;
    String houseArea;
    String housePrice;
    String houseType;
    String houseLocation;

    public House() {
    }

    @Override
    public String toString() {
        return "House{" +
                "sourcePrompt='" + sourcePrompt + '\'' +
                ", houseName='" + houseName + '\'' +
                ", houseArea='" + houseArea + '\'' +
                ", housePrice='" + housePrice + '\'' +
                ", houseType='" + houseType + '\'' +
                ", houseLocation='" + houseLocation + '\'' +
                '}';
    }

    public House(String sourcePrompt, String houseName, String houseArea, String housePrice, String houseType, String houseLocation) {
        this.sourcePrompt = sourcePrompt;
        this.houseName = houseName;
        this.houseArea = houseArea;
        this.housePrice = housePrice;
        this.houseType = houseType;
        this.houseLocation = houseLocation;
    }

    public String getSourcePrompt() {
        return sourcePrompt;
    }

    public void setSourcePrompt(String sourcePrompt) {
        this.sourcePrompt = sourcePrompt;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public String getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(String housePrice) {
        this.housePrice = housePrice;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseLocation() {
        return houseLocation;
    }

    public void setHouseLocation(String houseLocation) {
        this.houseLocation = houseLocation;
    }
}
