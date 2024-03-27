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

public class Testcase_002_Login_With_Correct_Email_Password {

    WebDriver driver = null ;
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
    public void LoginUser ()
    {

        registerPage.SignupButton(driver).click();


        String ExpectedLoginMsg = "Login to your account\n";
        String ActualLoginMsg = loginPage.LoginURL_Msg(driver).getText();

        Assert.assertTrue(ExpectedLoginMsg.contains(ActualLoginMsg));

        //write email
        loginPage.EmailField(driver).sendKeys("mostafawael@gmail.com");
        // write password
        loginPage.PasswordField(driver).sendKeys("123456789");

        loginPage.LoginButton(driver).click();


        String ExpectedLoginUser = "Mostafa Wael";
        String ActualLoginUser  = homePage.loginMsg(driver).getText();


        Assert.assertTrue(ExpectedLoginUser.contains(ActualLoginUser));

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
