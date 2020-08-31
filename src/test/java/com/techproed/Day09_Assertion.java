package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day09_Assertion {
    private static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    
    @Test
    public void test1(){
        driver.get("http://google.com");
        String gTitle = driver.getTitle();

        //to check if google title has 'search' in it

        //assert.Equals()
        //eger yazilan iki kavram es ise test pass, degilse test failed
        //expected vs actual
        Assert.assertEquals("search",gTitle);

    }

    @Test
    public void test2(){
        driver.get("http://amazon.com");

        String aTitle = driver.getTitle().toLowerCase();

        //amazon title must have 'amazon' in it

        boolean isContain = aTitle.contains("amazon");//true
        //assertTrue(boolean),
        Assert.assertTrue(isContain);
        //pass if the condition is true

    }
    @Test
    public void test3(){
        driver.get("http://facebook.com");
        String fTitle = driver.getTitle().toLowerCase();

        //facebook title i 'youtube' icermemeli

        boolean isContain = fTitle.contains("youtube");
        //conditions false ise pass
        Assert.assertFalse(isContain);

        //if the result is pass/true, then the rest will be compiled
        System.out.println("test3 is successfully done");
    }
    @Test
    public void test4(){
        driver.navigate().to("http://google.com");
        String gTitle = driver.getTitle();

        System.out.println("Helloo!!");

        Assert.assertEquals("google",gTitle);

        //if the test is failed, the rest of the code wont going to be compiled
        //bc it returns false
        System.out.println("test4 is done");
    }




    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
