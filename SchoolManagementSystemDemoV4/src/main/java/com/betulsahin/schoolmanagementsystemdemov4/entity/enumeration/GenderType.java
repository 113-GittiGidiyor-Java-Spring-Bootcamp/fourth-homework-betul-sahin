package com.betulsahin.schoolmanagementsystemdemov4.entity.enumeration;

public enum GenderType {
    FEMALE("Female"),
    MALE("Male");

    private String genderName;

    GenderType(String genderName){
        this.genderName = genderName;
    }

    public String getGenderName(){
        return genderName;
    }
}
