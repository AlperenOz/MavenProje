package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayedOrnek {
    static WebDriver driver;
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
    @Before
    public void b4(){
        driver.get("http://bestbuy.com");
    }

    @After
    public void afterMethod(){
        //driver.close();
        System.out.println("after method");
    }
    @Test
    public void titleTest(){
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Best"));
    }
    @Test
    public void logoTest(){
        WebElement logo = driver.findElement(By.cssSelector(".logo"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void mxLinkTest(){
        WebElement mxLink = driver.findElement(By.xpath("//a[3]"));
        Assert.assertTrue(mxLink.isDisplayed());
    }

}
