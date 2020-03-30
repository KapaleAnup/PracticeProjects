package com.qa.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {

    private static WebDriver driver;
    public static final long WAIT = 10;


    public void waitforVisibility(WebElement element){
      //  WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
      //  wait.until(ExpectedConditions.visibilityOf(element));
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

    public String getErrorMessage(WebElement element){
        return element.getText();
    }

    public boolean isValueSelected(WebElement element){
             waitforVisibility(element);
            return element.isSelected();
    }
    public boolean isValueDisplayed(WebElement element){
        waitforVisibility(element);
        return element.isDisplayed();
    }

    public boolean isValueEnabled(WebElement element){
        waitforVisibility(element);
        return element.isEnabled();

    }

    public void pageScrollDown(String data){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(data);
    }

    public void pageScrollHorizontally(String data, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }




}
