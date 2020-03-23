package com.qa.testcases;

import com.qa.pages.CartPage;
import com.qa.pages.HomePage;
import com.qa.testbase.TestBase;
import org.testng.Assert;
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
        homePage = new HomePage();
        cartPage = new CartPage();
    }


    @Test
    public void getCurrentUrl(){

        try {
            String currentUrl =  driver.getCurrentUrl();
            Log.info(currentUrl);

        }catch (Exception e){
            e.printStackTrace();
            Assert.fail(e.toString());
        }

    }

    @Test
    public void verifyProdcutName(){
        try{
            prodcutItemName = cartPage.checkProductName();
           Log.info("Product Name : " + prodcutItemName);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail(e.toString());
        }

    }

    @Test
    public void verifySelectedQuantity(){

        try{
            qty  = cartPage.checkQuanityPrice();
            Log.info("Selected  qty : " + qty);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail(e.toString());
        }


    }

    @Test
    public void verifyPrice(){
        try{
            price = cartPage.checkQuanityPrice();
            Log.info("Product price : " + price);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail(e.toString());

        }

    }

    @Test
    public void verifyTotalAmount(){
        try {
            totalAmount = cartPage.checkTotalAmount();
            System.out.println("Total amount is : " + totalAmount);
        }catch (Exception e){

            e.printStackTrace();
            Assert.fail(e.toString());

        }


    }

    @Test(dependsOnMethods = "verifyTotalAmount")
    public void verifyPlaceOrder(){

        try {
            cartPage.clickOnPlaceOrder();
            System.out.println("Order has been placed successfully..");
        }catch (Exception e ){
            e.printStackTrace();
            Assert.fail(e.toString());
        }

    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
