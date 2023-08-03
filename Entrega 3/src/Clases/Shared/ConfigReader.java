package Clases.Shared;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("../config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getClientSecret() {
        return properties.getProperty("CLIENT_SECRET");
    }
}
