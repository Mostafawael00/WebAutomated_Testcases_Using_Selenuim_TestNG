import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class Testcase_007_Search_For_Product {

    WebDriver driver = null ;
    HomePage homePage;
    ProductsPage productsPage;

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


        productsPage.SearchField(driver).sendKeys("Polo");
        productsPage.SearchButton(driver).click();

        String ExpectedSearchPage = "SEARCHED PRODUCTS";
        String ActualSearchPage = productsPage.SearchMsg(driver).getText();
        Assert.assertTrue(ExpectedSearchPage.contains(ActualSearchPage));

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
