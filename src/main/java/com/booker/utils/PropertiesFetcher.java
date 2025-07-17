package com.booker.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFetcher {

    public static String getPropertiesData(String key){
        try {
            InputStream input = PropertiesFetcher.class.getClassLoader().getResourceAsStream("config.properties");
            Properties properties = new Properties();
            properties.load(input);
            return properties.getProperty(key);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
