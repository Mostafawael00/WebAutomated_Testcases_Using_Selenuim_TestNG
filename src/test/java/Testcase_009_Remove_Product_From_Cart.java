import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class Testcase_009_Remove_Product_From_Cart {


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
    public void Remove_Product_From_Cart()
    {


        driver.findElement(By.xpath("//a[@href=\"/products\"]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //add first product to cart
        driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //click continue button
        driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button")).click();


        //add first product to cart
        driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // click view cart
        driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        // Try to delete 2 products
        driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[6]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[6]/a")).click();

        //verify 2 products are Deleted successfully
        String ExpectedEmptyMsg = "Cart is empty!";
        String ActualEmptyMsg = driver.findElement(By.xpath("//*[@id=\"empty_cart\"]/p")).getText();

        Assert.assertTrue(ExpectedEmptyMsg.contains(ActualEmptyMsg));



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
