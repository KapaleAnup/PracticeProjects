package com.qa.testcases;

import com.qa.pages.CartPage;
import com.qa.pages.HomePage;
import com.qa.testbase.TestBase;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HomePageTests extends TestBase {

    HomePage homePage ;
    CartPage cartPage;
    private static String prodcutName;

    public HomePageTests() throws IOException {
    }

    @BeforeClass
    public void setUp() throws IOException {
        initializeBrowsers("chrome");
        homePage = new HomePage();
    }

    @Test(priority = 1)
    public void verifyHomePageLogo(){
        homePage.verifyLogo();
    }

    @Test(priority = 2)
    public void verifyCartButton() throws IOException {
        homePage.clickOnCartButton();
    }

    @Test(priority = 3)
    public void VerifyCartIcon() throws IOException {
        homePage.clickOnCartIcon();
    }

  //  @Test
    public void verifySearch() throws IOException {

      String searchData = homePage.searchProductData("Cucumber");
      if(searchData.equals("Cucumber")){
          System.out.println("searched item found.");

         homePage.clickOnCartButton();
          System.out.println("Item has been added into the cart.");
      }else {
          System.out.println("no data found.");
      }

    }

    @Test(priority = 4)
    public void verifyProductInfo(){
        prodcutName= homePage.cartInfo();
        System.out.println("Product name of the selected item is : " + prodcutName);
    }

    @Test(priority = 5)
    public void verifyChecoutProceedButton(){
        try {
            homePage.clickOnProceedToCheckoutButton();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}
