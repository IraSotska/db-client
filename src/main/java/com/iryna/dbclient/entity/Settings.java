package com.iryna.dbclient.entity;

public class Settings {
    private String reportsPath;
    private String url;
    private String user;
    private String password;

    public Settings(String reportsPath, String url, String user, String password) {
        this.reportsPath = reportsPath;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getReportsPath() {
        return reportsPath;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

}
