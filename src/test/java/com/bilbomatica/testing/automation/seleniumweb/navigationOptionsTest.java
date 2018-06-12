package com.bilbomatica.testing.automation.seleniumweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class navigationOptionsTest {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        System.setProperty("webdriver.gecko.driver",
                "src" + File.separator + "main"
                        + File.separator + "resources"
                        + File.separator + "geckodriver-linux");
        driver = new FirefoxDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void navigationTest(){
        driver.navigate().to("http://www.google.com");
        assertTrue(driver.getTitle().toLowerCase().contains("google"));
        //driver.get("http://www.google.com");
        driver.navigate().to("http://www.yahoo.com");
        assertTrue(driver.getTitle().toLowerCase().contains("yahoo"));
        driver.navigate().back();
        assertTrue(driver.getTitle().toLowerCase().contains("google"));
        driver.navigate().forward();
        assertTrue(driver.getTitle().toLowerCase().contains("yahoo"));
        driver.navigate().refresh();
        assertTrue(driver.getTitle().toLowerCase().contains("yahoo"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
