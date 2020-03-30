package com.qa.pages;

import com.qa.testbase.TestBase;
import com.qa.utilities.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage  extends TestBase {

    TestUtils testUtils = new TestUtils();

    @FindBy(xpath = "//div[@class=\"brand greenLogo\"]")
    private  WebElement prodcutLogo;

    @FindBy(xpath = "//body//footer//p[1]")
    private WebElement pageFooter;

    @FindBy(xpath = "//div[@class='products']")
    private WebElement pageData;

    @FindBy(xpath = "//div[@class='products']//div[1]//div[3]//button[1]")
    private WebElement clickOnAddCartButton;

    @FindBy(xpath = "//input[@placeholder='Search for Vegetables and Fruits']")
    private WebElement searchProduct;

    @FindBy(xpath = "//button[@class='search-button']")
    private WebElement searchIcon;

    @FindBy(xpath = "//h4[@class='product-name']")
    private WebElement productName;

    @FindBy(xpath = "//a[@class='cart-icon']")
    private WebElement cartIcon;

    @FindBy(xpath = "//div[@class='cart-preview active']//div//div//p[@class='product-name']")
    private WebElement prodcutinfo;

    // //div[@class='cart-preview active']//div//div//h2[contains(text(),'You cart is empty!')]

    @FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")
    private WebElement checkoutButton;

    public HomePage() throws IOException {
        PageFactory.initElements(driver,this);
    }


    public HomePage clickOnCartIcon() {
       testUtils.clickElement(cartIcon);
       return this;

    }
    public boolean verifyLogo(){
//       boolean flag= prodcutLogo.isDisplayed();
//        Assert.assertEquals(prodcutLogo,flag);
        return true ;

    }

//    public String verifyTitle(){
//        getAttribute();
//        return driver.getTitle();
//    }

    public HomePage searchProductData(String data){
        searchProduct.sendKeys(data);
        searchIcon.click();
     // sendKeys(searchProduct, data);
        return this;
    }

    public boolean SearchedPrdocutName(){

      return productName.isDisplayed();

 // testUtils.getAttribute(productName,"text");

    }
    public String cartInfo(){
        prodcutinfo.isDisplayed();
       return prodcutinfo.getAttribute("text");


    }

    public HomePage clickOnCartButton()  {
        testUtils.clickElement(clickOnAddCartButton);
        return this;

    }
    public CartPage clickOnProceedToCheckoutButton() throws IOException {
        testUtils.clickElement(checkoutButton);
        return new CartPage();
    }




}


