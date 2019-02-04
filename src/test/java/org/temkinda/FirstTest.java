package org.temkinda;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    private static WebDriver driver;

    private String url = "http://www.google.com/xhtml";
    @BeforeClass
    public static void setup(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/temkinda/Downloads/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        Thread.sleep(5000);
    }

    @Test
    public void enterTextToSearchBox() throws InterruptedException{
        //WebElement button = driver.findElement(By.xpath());
        //ArrayList<WebElement> element = driver.findElements(By.xpath(""));
        java.util.List element = driver.findElements(By.xpath(""));


//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("ChromeDriver");
//        searchBox.submit();
        Thread.sleep(5000);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}