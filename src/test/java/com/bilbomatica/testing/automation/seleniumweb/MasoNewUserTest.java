package com.bilbomatica.testing.automation.seleniumweb;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class MasoNewUserTest extends BaseTest {
    @Test
    public void testSearch() throws Exception {
        //Code to login to the application


        driver.get("http://emsng.on-dockerlab.bilbomatica.es:8181/Maso");
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("on-dockerlab\\administrator" + Keys.TAB + "Bilb0tor!");
        alert.accept();

        //create a new user from the list
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/div/app-maso/div/kendo-grid/kendo-grid-toolbar/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/div/app-maso/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[1]/input")).sendKeys("selenium test jpf41");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/div/app-maso/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[2]/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/div/app-maso/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[3]/input")).sendKeys("5");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/div/app-maso/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[6]/button[4]")).click();
        Thread.sleep(2000);

        //click twice the column header so that the item we just created comes out on top
        driver.findElement(By.xpath("/html/body/app-root/div/div/app-maso/div/kendo-grid/div/div/div/table/thead/tr/th[5]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/div/app-maso/div/kendo-grid/div/div/div/table/thead/tr/th[5]/a")).click();
        Thread.sleep(2000);

        //Hover over an element to make the button appear, then click it
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("/html/body/app-root/div/div/app-maso/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[6]"));
        Thread.sleep(2000);
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("/html/body/app-root/div/div/app-maso/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[6]/button[1]"))).click().build().perform();
        Thread.sleep(2000);

        //Begin modifying the item (reused code from the creation part)
        driver.findElement(By.xpath("/html/body/app-root/div/div/app-maso/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[1]/input")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/div/app-maso/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[1]/input")).sendKeys("Modified item via selenium jpf41");
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/app-root/div/div/app-maso/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[6]/button[4]")).click();
        Thread.sleep(5000);






    }

}