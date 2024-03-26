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

public class Testcase_003_Login_With_Incorrect_Email_or_Password {

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
    public void LoginUser ()
    {

        driver.findElement(By.xpath("//a[@href=\"/login\"]")).click();


        String ExpectedRegistrationMsg = "Login to your account\n";
        String ActualRegistrationMsg = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")).getText();

        Assert.assertTrue(ExpectedRegistrationMsg.contains(ActualRegistrationMsg));

        //write email
        driver.findElement(By.xpath("//input[@data-qa=\"login-email\"]")).sendKeys("mostafawael562@gmail.com");
        // write password
        driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]")).sendKeys("123456789");

        driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]")).click();


        String ExpectedLoginMsg = "Your email or password is incorrect!";
        String ActualLoginMsg  = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")).getText();


        Assert.assertTrue(ExpectedLoginMsg.contains(ActualLoginMsg));

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