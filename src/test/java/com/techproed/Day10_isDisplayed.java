package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayed {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }

    @Test
    public void test1(){
        //go to google
        driver.get("http://google.com");

        //find the Google logo
        WebElement logo = driver.findElement(By.id("hplogo"));

        //isDisplayed() code un visibility sine bakar
        Assert.assertTrue(logo.isDisplayed());//true >> passed


    }

}
