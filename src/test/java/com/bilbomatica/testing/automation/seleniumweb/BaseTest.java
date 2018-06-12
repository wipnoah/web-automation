package com.bilbomatica.testing.automation.seleniumweb;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public RemoteWebDriver driver;
    public Actions hover;
    public static long timeOut = 120;
    public static LocalRemoteWebDriverWait wait;
    public static JavascriptExecutor jse;

    @BeforeMethod
    public void setUp() {
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        System.setProperty("webdriver.chrome.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator + "chromedriver-linux");
//        driver = new ChromeDriver(capabilities);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        System.setProperty("webdriver.gecko.driver",
                "src" + File.separator + "main"
                        + File.separator + "resources"
                        + File.separator + "geckodriver.exe");
        driver = new FirefoxDriver(capabilities);
        wait = new LocalRemoteWebDriverWait(driver, timeOut);
        hover = new Actions(driver);

        /*DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        System.setProperty("webdriver.internetexplorer.driver",
                "src" + File.separator + "main"
                        + File.separator + "resources"
                        + File.separator + "IEDriverServer.exe");

        //driver = new InternetExplorerDriver(capabilities);
        WebDriver driver = new InternetExplorerDriver();
        wait = new LocalRemoteWebDriverWait(driver, timeOut);
        hover = new Actions(driver);*/

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(timeOut, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
