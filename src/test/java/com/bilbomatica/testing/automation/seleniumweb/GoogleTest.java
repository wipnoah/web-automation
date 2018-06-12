package com.bilbomatica.testing.automation.seleniumweb;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GoogleTest extends BaseTest {
    @Test
    public void testSearch() {
        driver.get("http://www.google.com");
        assertTrue(driver.getTitle().equals("Google"));
    }
}
