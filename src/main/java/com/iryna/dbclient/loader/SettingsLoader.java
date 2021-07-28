package com.iryna.dbclient.loader;

import com.iryna.dbclient.entity.Settings;
import com.iryna.dbclient.properties.PropertiesService;

public class SettingsLoader {

    private static final String USER_NAME_VAR = "user";
    private static final String DB_URL_VAR = "url";
    private static final String PASSWORD_VAR = "password";
    private static final String REPORTS_PATH_VAR = "reportsPath";

    public static Settings load() {
        PropertiesService propertiesService = new PropertiesService();
        return new Settings(
                System.getenv(REPORTS_PATH_VAR) == null ? propertiesService.reportsPath : System.getenv(REPORTS_PATH_VAR),
                System.getenv(DB_URL_VAR) == null ? propertiesService.url : System.getenv(DB_URL_VAR),
                System.getenv(USER_NAME_VAR) == null ? propertiesService.user : System.getenv(USER_NAME_VAR),
                System.getenv(PASSWORD_VAR) == null ? propertiesService.password : System.getenv(PASSWORD_VAR));
    }
}
