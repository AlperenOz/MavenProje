package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_BeforeAfterClass {

    //BeforeClass & AfterClass HER ZAMAN CALISIR
    //@Ignore desek bile calisir o derece
    //static olmali, JUnit tin son update i ile gelmis
    @BeforeClass //runs first, before the whole class, runs only once
    public static void setup(){
        System.out.println("Setup calisti");
    }

    @AfterClass //runs last, after the whole class, runs only once
    public static void tearDown(){
        System.out.println("TearDown calisti");
    }

    @Test
    public void test01(){
        System.out.println("Test1 calisti");
    }
    @Test
    public void test02(){
        System.out.println("Test2 calisti");
    }

}
