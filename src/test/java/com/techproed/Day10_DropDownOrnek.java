package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day10_DropDownOrnek {
    //Amazona git
    //dropdown da software category sini sec
    //search box a "java" gir ve ara
    //sonuc sayisini ekrana yazdir
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://amazon.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test(){
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select opt = new Select(dropDown);
        opt.selectByVisibleText("Software");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("JAVA" + Keys.ENTER);

        //css selector da class name leri arasinda bosluklar varsa bunlar "." ile replace et
        WebElement numResults = driver.findElement(By.cssSelector(".a-section.a-spacing-small.a-spacing-top-small"));
        System.out.println(numResults.getText());

        Assert.assertTrue(numResults.getText().contains("JAVA"));
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
