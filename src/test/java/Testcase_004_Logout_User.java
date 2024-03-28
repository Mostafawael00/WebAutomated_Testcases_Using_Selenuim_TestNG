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

    RegistrationPage registrationPage;
    LoginPage loginPage;
    HomePage homePage;


    WebDriver driver = null;


    @BeforeTest
    public void openBrowser()
    {
        // to open chrome with extension
        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions( new File("./Extensions/AdBlock.crx"));

        driver = new ChromeDriver(opt);
        driver.navigate().to("https://automationexercise.com/");

        registrationPage = new RegistrationPage();
        loginPage = new LoginPage();
        homePage = new HomePage();

    }


    @Test
    public void LogoutUser ()
    {

        registrationPage.SignupButton(driver).click();


        String ExpectedRegistrationMsg = "Login to your account\n";
        String ActualRegistrationMsg = loginPage.LoginURL_Msg(driver).getText();

        Assert.assertTrue(ExpectedRegistrationMsg.contains(ActualRegistrationMsg));

        loginPage.EmailField(driver).sendKeys("mostafawael@gmail.com");

        loginPage.PasswordField(driver).sendKeys("123456789");

        loginPage.LoginButton(driver).click();


        String ExpectedLoginUser = "Mostafa Wael";
        String ActualLoginUser  = homePage.loginMsg(driver).getText();


        Assert.assertTrue(ExpectedLoginUser.contains(ActualLoginUser));

        homePage.LogoutButton(driver).click();

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
