package com.qa.testbase;

import com.qa.utilities.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class TestBase {
    public static WebDriver driver;
    protected static Properties prop;
    FileInputStream fileInputStream;
    public static Logger Log;

    //Create a consturctor to read the properties from config file

    public TestBase() throws IOException {

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

    @Parameters({"browser"})
    public void initializeBrowsers(String browser){

        Log  = Logger.getLogger(getClass().getName());
        PropertyConfigurator.configure("log4j.properties");

        try {
            if(browser.equals("chrome") || browser.equals("Chrome")){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }else if(browser.equals("firefox") || browser.equals("Firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }else{
              Log.info("No browser has been initialized.");
            }


            driver.get(prop.getProperty("url"));
            Log.info("Url has been launched.");

        }catch (Exception e){
            e.printStackTrace();
            throw  e;
        }



    }

    public void waitforVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElement(WebElement element){
        waitforVisibility(element);
        element.click();
    }

    public String sendKeys(WebElement element, String text){
        waitforVisibility(element);
        element.sendKeys(text);
        return text;
    }

    public String getAttribute(WebElement element, String attribute){
        waitforVisibility(element);
       return element.getAttribute(attribute);
    }


    public void quiteDriver(){
        driver.quit();
    }
}
