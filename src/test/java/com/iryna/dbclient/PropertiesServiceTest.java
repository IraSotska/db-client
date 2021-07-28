package com.iryna.dbclient;

import com.iryna.dbclient.properties.PropertiesService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesServiceTest {

    private PropertiesService propertiesService = new PropertiesService();

    @Test
    void checkProperties() {
        assertEquals("app123", propertiesService.password);
        assertEquals("D:/reports/", propertiesService.reportsPath);
        assertEquals("jdbc:postgresql://localhost:5432/postgres", propertiesService.url);
        assertEquals("application", propertiesService.user);
    }
}