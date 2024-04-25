import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.util.ArrayList;

public class TestCase_001_RegisterUser {

    //try
    WebDriver driver = null ;
    RegistrationPage registerPage;

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


         registerPage = new RegistrationPage();

    }

    @Test
    public void RegisterUser () throws InterruptedException {


        registerPage.SignupButton(driver).click();

        String ExpectedRegistrationMsg = "New User Signup!";
        String ActualRegistrationMsg = registerPage.SignupMsg(driver).getText();

        Assert.assertTrue(ExpectedRegistrationMsg.contains(ActualRegistrationMsg));


        registerPage.NameField(driver).sendKeys("Mostafa Wael");
        registerPage.EmailField(driver).sendKeys("mostafawael1@gmail.com");
        registerPage.SignupButton2(driver).click();


        String ExpectedSignupMsg = "ENTER ACCOUNT INFORMATION";
        String ActualSignupMsg = registerPage.RegistrationMsg(driver).getText();

        Assert.assertTrue(ExpectedSignupMsg.contains(ActualSignupMsg));


        registerPage.GenderField(driver).click();

        registerPage.PasswordField(driver).sendKeys("123456789");


        Select DayDropdown =new Select(registerPage.DaySelect(driver));
        DayDropdown.selectByValue("23");

        Select MonthsDropdown =new Select(registerPage.MonthSelect(driver));
        MonthsDropdown.selectByValue("4");

        Select YearDropdown =new Select(registerPage.YearSelect(driver));
        YearDropdown.selectByValue("1997");

        registerPage.NewsLetterCheckBox(driver).click();
        registerPage.OptionCheckBox(driver).click();

        registerPage.FirstNameField(driver).sendKeys("Mostafa");

        registerPage.LastNameField(driver).sendKeys("Wael");

        registerPage.CompanyField(driver).sendKeys("ITI");

        registerPage.AddressField(driver).sendKeys("Cairo-Egypt");


        Thread.sleep(3000);


        registerPage.StateField(driver).sendKeys("Giza");

        registerPage.CityField(driver).sendKeys("6 October");

        registerPage.ZipcodeField(driver).sendKeys("1658955");

        registerPage.MobileNumberField(driver).sendKeys("01069650017");


        Thread.sleep(5000);


        registerPage.CreateAccountButton(driver).click();


        Thread.sleep(1000);


        String ExpectedCreateMsg = "ACCOUNT CREATED!";
        String ActualCreateMsg = registerPage.CreateAccMsg(driver).getText();

        Assert.assertTrue(ExpectedCreateMsg.contains(ActualCreateMsg));


        // click on continue button after account created
        registerPage.ContinueButton(driver).click();


        //click on delete account
        registerPage.DeleteAccButton(driver).click();

        String ExpectedDeleteMsg = "ACCOUNT DELETED!" ;
        String ActualDeleteMsg = registerPage.DeletdAccMsg(driver).getText();
        Assert.assertTrue(ExpectedDeleteMsg.contains(ActualDeleteMsg));

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