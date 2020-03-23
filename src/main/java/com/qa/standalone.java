package com.qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class standalone {
    public static WebDriver driver;
    protected static Properties prop;
    FileInputStream fileInputStream;

    public standalone() throws IOException {

        try {
            prop = new Properties();
            //  String propFileName = "config.properties";

            //   fileInputStream = (FileInputStream) getClass().getClassLoader().getResourceAsStream(propFileName);
            fileInputStream = new FileInputStream("/Users/anupkapale/Documents/PracticeProjects/src/main/java/com/qa/config/config.properties");
            prop.load(fileInputStream);


        }catch (Exception e){
            e.printStackTrace();
            throw  e;
        }

    }


    @BeforeTest
    public static void initializeBrowsers(){


                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();


            driver.get(prop.getProperty("url"));




    }

    @Test
    public void productJourney(){

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='products']//div[1]//div[3]//button[1]")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();

        String productinfo = driver.findElement(By.xpath("//div[@class='cart-preview active']//div//div//p[@class='product-name']")).getText();
        System.out.println(productinfo);

        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();


        String productname = driver.findElement(By.xpath("//p[@class='product-name']")).getText();
        System.out.println(productname);

        String price =  driver.findElement(By.xpath("//td[4]//p[1]")).getText();
        System.out.println(price);


        // div[@class='cart-preview active']//div//div//li[@class='cart-item']

        // driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[2]"));

        // driver.findElement(By.xpath("//div[@class='cart-preview active']//div//div//p[@class='product-name'][contains(text(),'Brocolli - 1 Kg')]"));
    }

}
