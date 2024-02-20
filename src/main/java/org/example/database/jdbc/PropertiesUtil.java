package org.example.database.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public final class PropertiesUtil {

    public static final Properties PROPERTIES  = new Properties();

    static {
        loadProperties();
    }
    private PropertiesUtil(){}

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties(){
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("Application.Properties")){
            PROPERTIES.load(inputStream);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
