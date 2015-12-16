package com.qatestlab.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Random;

public class SecondTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void firstTest() throws InterruptedException {
        //Firefox
        Reporter.log("Open Firefox page \n");
        driver.get("http://prestashop.qatestlab.com.ua/en/");

        //Click random popular product
        Random randomProduct = new Random();
        int randomProductNumber = randomProduct.nextInt(8) + 1;
        Reporter.log("Random product value:" + randomProductNumber + "\n");
        driver.findElement(By.xpath("//ul[@id='homefeatured']/li[" + randomProductNumber + "]/div/div/h5/a")).click();
        Thread.sleep(3000);

        //Cart counting test
        Reporter.log("Product page opened \n");
        String previousProductCount = driver.findElement(By.xpath("//div[contains(@class, 'shopping_cart')]/a/span[contains(@class, 'ajax_cart_quantity')]")).getText();
        if (previousProductCount.isEmpty()) {previousProductCount = "0";}
        Reporter.log("Previous product count:" + previousProductCount + "\n");
        driver.findElement(By.id("quantity_wanted")).clear();
        driver.findElement(By.id("quantity_wanted")).sendKeys("" + randomProductNumber);
        driver.findElement(By.name("Submit")).click();
        Thread.sleep(3000);
        driver.get(driver.getCurrentUrl()); //reload page, because sometimes products count doesn't updated
        Thread.sleep(3000);
        String newProductCount = driver.findElement(By.xpath("//div[contains(@class, 'shopping_cart')]/a/span[contains(@class, 'ajax_cart_quantity')]")).getText();
        Reporter.log("New product count:" + newProductCount + "\n");
        Assert.assertEquals(Integer.parseInt(newProductCount), Integer.parseInt(previousProductCount) + randomProductNumber, "Shopping cart counting mistake!");

    }

    @AfterClass
    public void TearDown(){
        driver.quit();
    }
}
