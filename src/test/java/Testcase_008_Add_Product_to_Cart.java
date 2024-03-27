import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class Testcase_008_Add_Product_to_Cart {

    WebDriver driver = null ;
    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;

    @BeforeTest
    public void openBrowser()
    {
        // to open chrome with extension
        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions( new File("./Extensions/AdBlock.crx"));

        driver = new ChromeDriver(opt);
        driver.navigate().to("https://automationexercise.com/");

        homePage = new HomePage();
        productsPage = new ProductsPage();
        cartPage = new CartPage();


    }

    @Test
    public void Add_Product_to_Cart()
    {


        homePage.ProductsButton(driver).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //add first product to cart
        productsPage.AddProduct1(driver).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //click continue button
        productsPage.ContinueButton(driver).click();


        //add second product to cart
        productsPage.AddProduct2(driver).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // click view cart
        productsPage.ViewCartButton(driver).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //verify 2 products are added successfully
        Assert.assertTrue(cartPage.Product1Displayed(driver).isDisplayed());
        Assert.assertTrue(cartPage.Product2Displayed(driver).isDisplayed());

    }

    @AfterTest
    public void ClosBrowser()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }




}
