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

    @BeforeTest
    public void openBrowser()
    {
        // to open chrome with extension
        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions( new File("./Extensions/AdBlock.crx"));

        driver = new ChromeDriver(opt);
        driver.navigate().to("https://automationexercise.com/");

    }
    @Test
    public void Verify_Products_Search()
    {



        driver.findElement(By.xpath("//a[@href=\"/products\"]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.findElement(By.id("search_product")).sendKeys("Polo");
        driver.findElement(By.id("submit_search")).click();

        String ExpectedSearchPage = "SEARCHED PRODUCTS";
        String ActualSearchPage = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/h2")).getText();
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
