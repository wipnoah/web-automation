package com.bilbomatica.testing.automation.seleniumweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class KatalonExampleTest {
    private WebDriver driver;
    private String browser;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        browser = System.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            System.setProperty("webdriver.chrome.driver",
                    "src" + File.separator + "main"
                            + File.separator + "resources"
                            + File.separator + "chromedriver-linux");
            driver = new ChromeDriver(capabilities);
        } else {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            System.setProperty("webdriver.gecko.driver",
                    "src" + File.separator + "main"
                            + File.separator + "resources"
                            + File.separator + "geckodriver-linux");
            driver = new FirefoxDriver(capabilities);
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.id("search_form_input_homepage")).click();
        driver.findElement(By.id("search_form_input_homepage")).clear();
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("pizza hawaiana");
        driver.findElement(By.id("search_button_homepage")).click();
        driver.findElement(By.xpath("//div[@id='r1-0']/div/h2/a/b[2]")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
