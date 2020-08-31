package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_IkinciOrnek {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    @Before //go to google before the tests, its like refreshing
    public void b4(){
        driver.get("http://google.com");
    }
    @After
    public void after(){
        WebElement resultStats = driver.findElement(By.id("result-stats"));
        System.out.println(resultStats.getText());
    }

    @Test
    public void test1(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("apple");

        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();
    }

    @Test
    public void test2(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("samsung headphone" + Keys.ENTER);
    }

    @Test
    public void test3(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("working table");
        searchBox.submit();
    }

}
