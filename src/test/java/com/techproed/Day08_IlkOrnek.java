package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_IlkOrnek {
    //to reach this driver from all the methods below, its declared as instance variable
    static ChromeDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void test01(){

        //check if the title of Google contains google
        driver.get("http://google.com");
        String result = driver.getTitle().toLowerCase().contains("google")? "Pass" :"Failed";
        System.out.println(driver.getTitle());
        System.out.println(result);

    }
}
