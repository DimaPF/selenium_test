package com.qatestlab.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;

public class FirstTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void firstTest() throws InterruptedException {
        //Firefox: founding Logo on page
        Reporter.log("Open Firefox page \n");
        driver.get("http://prestashop.qatestlab.com.ua/en/");
        String logoURL = driver.findElement(By.xpath("//img[contains(@class, 'logo') and contains(@class,'img-responsive')]")).getAttribute("src");
        Reporter.log("Get logo URL:" + logoURL + "\n");
        Assert.assertEquals(logoURL,"http://prestashop.qatestlab.com.ua/img/logo.jpg", "Logo URL NOT found or was changed \n");

        //Open Logo to check if it available
        driver.get("http://prestashop.qatestlab.com.ua/img/logo.jpg");
        Reporter.log("Logo is available. \n");
        Thread.sleep(3000);

        //counting of products on page
        driver.get("http://prestashop.qatestlab.com.ua/en/");
        int listCount = 0;
        for (Iterator<WebElement> currentElement =  driver.findElements(By.xpath("//ul[@id='homefeatured']/li")).listIterator(); currentElement.hasNext(); ) {
            currentElement.next();
            currentElement.remove();
            listCount++;
        }
        Reporter.log("List Count:" + listCount + "\n");
        Assert.assertEquals(listCount, 8, "Product elements count was changed! \n");

    }

    @AfterClass
    public void TearDown(){
        driver.quit();
    }

}
