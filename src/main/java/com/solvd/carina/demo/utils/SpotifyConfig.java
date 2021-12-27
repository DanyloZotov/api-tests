package com.solvd.carina.demo.utils;

import java.io.*;
import java.util.Properties;

public class SpotifyConfig {
    private static SpotifyConfig instance;
    private Properties properties = new Properties();
    private File fileProperties = new File("src/main/resources/_spotify.properties");

    private SpotifyConfig(){
        initProperties();
    }
    public static SpotifyConfig getInstance(){
        if(SpotifyConfig.instance == null){
            SpotifyConfig.instance = new SpotifyConfig();
        }
        return SpotifyConfig.instance;
    }

    private void initProperties(){
        try {
            FileInputStream fileInputStream = new FileInputStream(fileProperties);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setProperty(String value){
        getInstance().properties.setProperty("spotify_token", value);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(getInstance().fileProperties);
            getInstance().properties.store(fileOutputStream, null);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        instance.initProperties();
    }

    public static String getProperty(String name){
        return getInstance().properties.getProperty(name);
    }

}
