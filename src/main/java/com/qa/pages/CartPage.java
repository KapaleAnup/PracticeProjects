package com.qa.pages;

import com.qa.testbase.TestBase;
import com.qa.utilities.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CartPage extends TestBase {

    TestUtils testUtils = new TestUtils();

    public CartPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[@class='product-name']")
    private WebElement productName;

    @FindBy(xpath = "//p[@class='quantity']")
    private WebElement quantityData;

    @FindBy(xpath = "//td[4]//p[1]")
    private WebElement qtyprice;

    @FindBy(xpath = "//td[5]//p[1]")
    private WebElement totalAmount;


    @FindBy(xpath = "//button[contains(text(),'Place Order')]")
    private WebElement btnPlaceOrder;



    public String getCurrentlUrl(){
        return driver.getCurrentUrl();
    }
    public String checkProductName(){
       return productName.getText();
    }

    public String checkSelectedQuantity(){
        return quantityData.getText();
    }

    public String checkQuanityPrice(){
        return qtyprice.getText();
    }

    public String checkTotalAmount(){
        return totalAmount.getText();
    }

    public void clickOnPlaceOrder(){
        testUtils.clickElement(btnPlaceOrder);
    }




}
