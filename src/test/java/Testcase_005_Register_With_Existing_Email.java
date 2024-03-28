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

    RegistrationPage registerPage;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeTest
    public void openBrowser()
    {
        // to open chrome with extension
        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions( new File("./Extensions/AdBlock.crx"));

        driver = new ChromeDriver(opt);
        driver.navigate().to("https://automationexercise.com/");

        registerPage = new RegistrationPage();
        loginPage = new LoginPage();
        homePage = new HomePage();

    }

    @Test
    public void RegisterUser ()
    {

        registerPage.SignupButton(driver).click();


        String ExpectedRegistrationMsg = "New User Signup!";
        String ActualRegistrationMsg = registerPage.SignupMsg(driver).getText();

        Assert.assertTrue(ExpectedRegistrationMsg.contains(ActualRegistrationMsg));

        registerPage.NameField(driver).sendKeys("Mostafa Wael");
        registerPage.EmailField(driver).sendKeys("mostafawael@gmail.com");
        registerPage.SignupButton2(driver).click();


        String ExpectedExistingMsg = "Email Address already exist!";
        String ActualExistingMsg = registerPage.EmailExisingMsg(driver).getText();

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
