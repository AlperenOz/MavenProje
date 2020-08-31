package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day10_DropDown {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @Test
    public void test1(){
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

 /*
    DROPDOWN I KULLANABILMEK ICIN SELECT CLASS INDAN URETILMIS BIR OBJECT LAZIM
 */

        //WebElement dropDown i alip select e atadik
        Select select = new Select(dropDown);

        //WAYS TO FIND ONE OF THE OPTIONS IN THE DROPDOWN
        //SELECT CLASS
        //INTERVIEW LARDA SORULUR BU >> DROPDOWN DENIRSE ==> SELECT

        //select.ByIndex() >> tis for its index, kacinci sirada?
        select.selectByIndex(4);//4th one is beauty

        //selectByValue() >> tis for its value in the inspection part
        select.selectByValue("search-alias=baby-products-intl-ship");

        //selectByVisibleText() >> tis for its Text if its visible
        select.selectByVisibleText("Books");


        //SECIMI EKRANA YAZDIRMAK, NE SECTIGIMIZI ANLAMAK
        WebElement secim = select.getFirstSelectedOption();
        System.out.println(secim.getText());
        
        
        //TUM OPTION LARI EKRANA YAZDIRMAK
        //.getOptions() + for loop
        List<WebElement> secimlerList = select.getOptions();
        for (WebElement w: secimlerList ) {
            System.out.println(w.getText());
        }

        //FIND HOW MANY OPTIONS THERE ARE
        //size()
        System.out.println("number of options: " + secimlerList.size());

    }

}
