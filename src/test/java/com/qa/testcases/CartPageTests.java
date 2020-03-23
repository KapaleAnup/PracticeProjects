package com.qa.testcases;

import com.qa.pages.CartPage;
import com.qa.pages.HomePage;
import com.qa.testbase.TestBase;
import org.testng.annotations.*;

import java.io.IOException;

public class CartPageTests extends TestBase {

    HomePage homePage;
    CartPage cartPage;

    private  static String prodcutItemName;
    private  static String qty;
    private  static String price;
    private  static String totalAmount;
    public CartPageTests() throws IOException {
    }

    @BeforeClass
    public void setUp() throws IOException {
        initializeBrowsers("chrome");
        homePage = new HomePage();
        cartPage = new CartPage();
    }


    @Test(priority = 1)
    public void getCurrentUrl(){
      String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);
    }

    @Test(priority = 2)
    public void verifyProdcutName(){
       prodcutItemName = cartPage.checkProductName();
        System.out.println("Product Name : " + prodcutItemName);
    }

    @Test(priority = 3)
    public void verifySelectedQuantity(){
       qty  = cartPage.checkQuanityPrice();
        System.out.println("Selected  qty : " + qty);

    }

    @Test(priority = 4)
    public void verifyPrice(){
        price = cartPage.checkQuanityPrice();
        System.out.println("Product price : " + price);
    }

    @Test(priority = 5)
    public void verifyTotalAmount(){
        totalAmount = cartPage.checkTotalAmount();
        System.out.println("Total amount is : " + totalAmount);

    }

    @Test(priority = 6)
    public void verifyPlaceOrder(){
        cartPage.clickOnPlaceOrder();
        System.out.println("Order has been placed successfully..");
    }







    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
