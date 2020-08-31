package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day07_IlkDers {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        //Browserlari kullanabilmek icin WebDriverManager libr. kull.
        //instead of going System.property...., we just type this
        //thanks to the imported library in maven, this code is enough

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("samsung headphones" + Keys.ENTER);
        //Keys.ENTER is to click the enter key in the keyboard

        WebElement numOfResults = driver.findElement(By.xpath("//span[@dir='auto']"));
        System.out.println(numOfResults.getText());

        WebElement firstProd = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        System.out.println(firstProd.getText());

        List<WebElement> allProds = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement w: allProds) {
            System.out.println(w.getText());
        }
    }
}
