package com.iryna.dbclient.creator;

import java.io.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ReportCreator {

    private String reportsPath;

    public void createReport(ResultSet resultSet) {
        try {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<table>\n");
            stringBuilder.append("\t<tr>\n");
            for (int i = 0; i < columnCount; i++) {
                stringBuilder.append("\t\t<th>" + resultSetMetaData.getColumnLabel(i + 1) + "</th>\n");
            }
            stringBuilder.append("\t</tr>\n");
            while (resultSet.next()) {
                stringBuilder.append("\t<tr>\n");
                for (int i = 0; i < columnCount; i++) {
                    Object value = resultSet.getObject(i + 1);
                    stringBuilder.append("\t\t<td>" + value.toString() + "</td>\n");
                }
                stringBuilder.append("\t</tr>\n");
            }
            stringBuilder.append("</table>\n");
            saveReportToFile(stringBuilder.toString());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    protected void saveReportToFile(String report) {

        new File(reportsPath + "report.html").getParentFile().mkdirs();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(reportsPath + "report.html")))) {
            bufferedWriter.write(report);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void setReportsPath(String reportsPath) {
        this.reportsPath = reportsPath;
    }
}
