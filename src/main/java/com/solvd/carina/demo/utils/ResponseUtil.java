package com.solvd.carina.demo.utils;

public class ResponseUtil {
    public static String extractProperty(String response, String propertyName){
        String property = response.substring(response.indexOf(propertyName)+propertyName.length()+5);
        property = property.substring(0, property.indexOf("\""));
        return property;
    }
}
