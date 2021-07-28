package com.iryna.dbclient.creator;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ReportCreatorTest {

    private ReportCreator reportCreator = new ReportCreator();

    @Test
    void saveToFile() {
        reportCreator.setReportsPath("C:reports/");
        reportCreator.saveReportToFile("test");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("C:/reports/report.html")))) {
            assertEquals("test", bufferedReader.readLine());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}