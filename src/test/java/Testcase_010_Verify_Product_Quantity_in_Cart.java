import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class Testcase_010_Verify_Product_Quantity_in_Cart {

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
    public void Verify_Products_Search()
    {



        homePage.ProductsButton(driver).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        productsPage.AddProduct3(driver).click();

        productsPage.ClearQuantity(driver).clear();
        productsPage.SetQuantity(driver).sendKeys("4");

        //add to cart button
        productsPage.AddToCart(driver).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        productsPage.ViewCartButton(driver).click();


        String ExpectedQuantity =  "4";
        String ActualQuantity = cartPage.Quantity(driver).getText();

        Assert.assertEquals(ActualQuantity, ExpectedQuantity);

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
