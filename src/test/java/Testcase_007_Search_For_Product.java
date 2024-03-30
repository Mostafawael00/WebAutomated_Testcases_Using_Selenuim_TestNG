import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.util.ArrayList;

public class Testcase_007_Search_For_Product {

    WebDriver driver = null ;
    HomePage homePage;
    ProductsPage productsPage;

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
