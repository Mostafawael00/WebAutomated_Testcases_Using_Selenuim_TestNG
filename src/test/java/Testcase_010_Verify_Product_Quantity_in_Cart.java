import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.util.ArrayList;

public class Testcase_010_Verify_Product_Quantity_in_Cart {

    WebDriver driver = null ;
    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;

    @BeforeMethod
    public void openBrowser()
    {
        // to open chrome with extension
        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions( new File("./Extensions/AdBlock.crx"));

        driver = new ChromeDriver(opt);
        driver.navigate().to("https://automationexercise.com/");

        // to switch display the previous tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.getFirst());


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

    @AfterMethod
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
