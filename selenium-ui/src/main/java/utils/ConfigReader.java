package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//Clase lee archivo por defecto 
public class ConfigReader {
    private static Properties properties;

    // cargar configuracion inicial 
    static {
        try {
            String configFilePath = System.getProperty("user.dir") + "//src//main//resources//config.properties";
            System.out.println(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(configFilePath);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Falla al cargar archivo de configuracion");
        }

       
    }

    // get clave string
    public static String get(String key) {
        return properties.getProperty(key);
    }

    // get clave int 
    public static int getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }


}
