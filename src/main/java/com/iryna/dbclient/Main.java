package com.iryna.dbclient;

import com.iryna.dbclient.creator.ReportCreator;
import com.iryna.dbclient.db.DBService;
import com.iryna.dbclient.entity.Settings;
import com.iryna.dbclient.loader.SettingsLoader;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    private static final String CREATE_TABLE_REQUEST = ("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(255) NOT NULL, salary INT);");

    public static void main(String[] args) {

        Settings settings = SettingsLoader.load();
        Properties properties = new Properties();
        properties.setProperty("user", settings.getUser());
        properties.setProperty("password", settings.getPassword());
        DBService dbService = new DBService();

        try (Scanner in = new Scanner(System.in)) {
            ReportCreator reportCreator = new ReportCreator();
            reportCreator.setReportsPath(settings.getReportsPath());

            Connection connection = DriverManager.getConnection(settings.getUrl(), properties);
            dbService.setConnection(connection);
            dbService.setReportCreator(reportCreator);
            dbService.executeQuery(CREATE_TABLE_REQUEST);

            while (true) {
                if (in.hasNextLine()) {
                    dbService.executeQuery(in.nextLine());
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
