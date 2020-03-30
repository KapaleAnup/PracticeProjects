package com.qa.testcases;

import com.qa.pages.CartPage;
import com.qa.pages.HomePage;
import com.qa.testbase.TestBase;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class HomePageTests extends TestBase {

    HomePage homePage ;
    CartPage cartPage;
    private static String prodcutName;

    public HomePageTests() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp(Method method) throws IOException {
        initializeBrowsers("chrome");
        homePage = new HomePage();
        Log.info("\n"+ "***** Starting Test : "+ method.getName() + "********"+ "\n");
    }

    @Test
    public void verifyHomePageLogo(){
        homePage.verifyLogo();

    }

     @Test(priority = 1)
    public void verifyCartButton() throws IOException {
        homePage.clickOnCartButton();
    }

   // @Test(priority = 1)
    public void verifySearch() throws IOException {

        HomePage searchData = homePage.searchProductData("Cucumber");
        if(searchData.equals("Cucumber")){
            System.out.println("searched item found.");

            homePage.clickOnCartButton();
            System.out.println("Item has been added into the cart.");
        }else {
            System.out.println("no data found.");
        }

    }


    @Test(dependsOnMethods = "verifyCartButton")
    public void VerifyCartIcon() {
        homePage.clickOnCartIcon();
    }

    @Test(dependsOnMethods = "VerifyCartIcon")
    public void verifyProductInfo(){
        prodcutName = homePage.cartInfo();
        System.out.println("Product name of the selected item is : " + prodcutName);
    }

    @Test(dependsOnMethods = "verifyProductInfo")
    public void verifyCheckoutProceedButton(){
        try {
            cartPage = homePage.clickOnProceedToCheckoutButton();
        } catch (IOException e) {
            e.printStackTrace();
           // throw new RuntimeException("Checkout button is not working.");

        }

       String cartpageurl =  cartPage.getCurrentlUrl();
        Log.info(cartpageurl);
    }

    @Test
    public void checkProceedPage(){

    }



   // @AfterClass
    public void tearDown(){
        driver.quit();
    }





}
