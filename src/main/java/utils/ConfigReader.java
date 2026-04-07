package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try {
            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(input);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getEmail() {
        return properties.getProperty("login.email");
    }

    public static String getPassword() {
        return properties.getProperty("login.password");
    }

    public static String getAppUrl() {
        return properties.getProperty("app.url");
    }

    public static String getAppLoginUrl() {
        return properties.getProperty("app.login_url");
    }
}
