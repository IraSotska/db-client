package com.iryna.dbclient.db;

import com.iryna.dbclient.creator.ReportCreator;

import java.sql.*;
import java.util.Locale;

public class DBService {
    private Connection connection;
    private ReportCreator reportCreator;

    public void setReportCreator(ReportCreator reportCreator) {
        this.reportCreator = reportCreator;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void executeQuery(String query) {

        try {
            ResultSet resultSet = null;
            String command = query.substring(0, 6).toLowerCase(Locale.ROOT);
            if (command.equals("update")) {
                System.out.println("Rows updated : " + connection.createStatement().executeUpdate(query));
            } else {
                resultSet = connection.createStatement().executeQuery(query);
            }
            if (command.equals("select")) {
                reportCreator.createReport(resultSet);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
