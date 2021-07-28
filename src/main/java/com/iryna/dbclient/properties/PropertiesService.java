package com.iryna.dbclient.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesService {

    public final String reportsPath;
    public final String url;
    public final String user;
    public final String password;

    public PropertiesService() {
        Properties property = new Properties();

        try (InputStream is = PropertiesService.class.getClassLoader().getResourceAsStream("application.properties")) {
            property.load(is);
            this.reportsPath = property.getProperty("reportsPath");
            this.url = property.getProperty("url");
            this.user = property.getProperty("user");
            this.password = property.getProperty("password");
        } catch (IOException e) {
            throw new RuntimeException("Can't load configuration properties", e);
        }
    }
}
