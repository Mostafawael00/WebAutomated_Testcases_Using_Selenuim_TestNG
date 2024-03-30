import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.util.ArrayList;

public class Testcase_006_Verify_Product_Detailes_Page {


    WebDriver driver = null ;
    HomePage homePage;

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

    }

    @Test
    public void Verify_Product_Detaile_Page()
    {



        homePage.ProductsButton(driver).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //close  by close button
        /*driver.switchTo().frame("aswift_5");
        driver.switchTo().frame("ad_iframe");

        driver.findElement(By.xpath("//*[@id=\"dismiss-button\"]")).click();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();*/


        //close by x
        /*driver.switchTo().frame("aswift_5");
        driver.findElement(By.xpath("//*[@id=\"dismiss-button\"]")).click();
        driver.switchTo().parentFrame();*/

        String ExpectedProductsPage = "https://automationexercise.com/products";
        String ActualProductsPage = driver.getCurrentUrl();


        Assert.assertTrue(ExpectedProductsPage.contains(ActualProductsPage));

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
