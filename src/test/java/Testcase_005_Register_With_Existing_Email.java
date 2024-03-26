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

public class Testcase_005_Register_With_Existing_Email {

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
    public void RegisterUser ()
    {

        driver.findElement(By.xpath("//a[@href=\"/login\"]")).click();


        String ExpectedRegistrationMsg = "New User Signup!";
        String ActualRegistrationMsg = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2")).getText();

        Assert.assertTrue(ExpectedRegistrationMsg.contains(ActualRegistrationMsg));

        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Mostafa Wael");
        driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys("mostafawael@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();


        String ExpectedExistingMsg = "Email Address already exist!";
        String ActualExistingMsg = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/p")).getText();

        Assert.assertTrue(ExpectedExistingMsg.contains(ActualExistingMsg));

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
