import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class Testcase_004_Logout_User {


    WebDriver driver = null;


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
    public void LogoutUser ()
    {

        driver.findElement(By.xpath("//a[@href=\"/login\"]")).click();


        String ExpectedRegistrationMsg = "Login to your account\n";
        String ActualRegistrationMsg = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")).getText();

        Assert.assertTrue(ExpectedRegistrationMsg.contains(ActualRegistrationMsg));

        //write email
        driver.findElement(By.xpath("//input[@data-qa=\"login-email\"]")).sendKeys("mostafawael@gmail.com");
        // write password
        driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]")).sendKeys("123456789");

        driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]")).click();


        String ExpectedLoginUser = "Mostafa Wael";
        String ActualLoginUser  = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b")).getText();


        Assert.assertTrue(ExpectedLoginUser.contains(ActualLoginUser));

        //click on logout button
        driver.findElement(By.xpath("//a[@href=\"/logout\"]")).click();

        String ExpectedCurrentURL = "https://automationexercise.com/login";
        String ActualCurrentURL  = driver.getCurrentUrl();

        Assert.assertTrue(ExpectedCurrentURL.contains(ActualCurrentURL));

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
