import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class Testcase_003_Login_With_Incorrect_Email_or_Password {

    WebDriver driver = null ;

    RegistrationPage registrationPage;
    LoginPage loginPage;

    @BeforeTest
    public void openBrowser()
    {
        // to open chrome with extension
        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions( new File("./Extensions/AdBlock.crx"));

        driver = new ChromeDriver(opt);
        driver.navigate().to("https://automationexercise.com/");

        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();

    }

    @Test
    public void LoginUser ()
    {

        registrationPage.SignupButton(driver).click();


        String ExpectedRegistrationMsg = "Login to your account\n";
        String ActualRegistrationMsg = loginPage.LoginURL_Msg(driver).getText();

        Assert.assertTrue(ExpectedRegistrationMsg.contains(ActualRegistrationMsg));

        //write email
        loginPage.EmailField(driver).sendKeys("mostafawael562@gmail.com");
        // write password
        loginPage.PasswordField(driver).sendKeys("123456789");

        loginPage.LoginButton(driver).click();


        String ExpectedLoginMsg = "Your email or password is incorrect!";
        String ActualLoginMsg  = loginPage.unLogMsg(driver).getText();


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
