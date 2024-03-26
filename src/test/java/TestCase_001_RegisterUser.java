import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class TestCase_001_RegisterUser {

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
    public void RegisterUser () throws InterruptedException {

        driver.findElement(By.xpath("//a[@href=\"/login\"]")).click();


        String ExpectedRegistrationMsg = "New User Signup!";
        String ActualRegistrationMsg = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2")).getText();

        Assert.assertTrue(ExpectedRegistrationMsg.contains(ActualRegistrationMsg));

        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Mostafa Wael");
        driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys("mostafawael1@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();



        String ExpectedSignupMsg = "ENTER ACCOUNT INFORMATION";
        String ActualSignupMsg = driver.findElement(By.xpath("//b")).getText();

        Assert.assertTrue(ExpectedSignupMsg.contains(ActualSignupMsg));

        // select gender
        driver.findElement(By.id("id_gender1")).click();
        // write password
        driver.findElement(By.id("password")).sendKeys("123456789");


        Select DayDropdown =new Select(driver.findElement(By.id("days")));
        DayDropdown.selectByValue("23");

        Select MonthsDropdown =new Select(driver.findElement(By.id("months")));
        MonthsDropdown.selectByValue("4");

        Select YearDropdown =new Select(driver.findElement(By.id("years")));
        YearDropdown.selectByValue("1997");


        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();


        driver.findElement(By.xpath("//input[@data-qa=\"first_name\"]")).sendKeys("Mostafa");
        driver.findElement(By.xpath("//input[@data-qa=\"last_name\"]")).sendKeys("Wael");
        driver.findElement(By.xpath("//input[@data-qa=\"company\"]")).sendKeys("ITI");
        driver.findElement(By.xpath("//input[@data-qa=\"address\"]")).sendKeys("Cairo-Egypt");


        Thread.sleep(3000);



        driver.findElement(By.xpath("//input[@data-qa=\"state\"]")).sendKeys("Giza");

        driver.findElement(By.xpath("//input[@data-qa=\"city\"]")).sendKeys("6 October");

        driver.findElement(By.xpath("//input[@data-qa=\"zipcode\"]")).sendKeys("1658955");

        driver.findElement(By.xpath("//input[@data-qa=\"mobile_number\"]")).sendKeys("01069650017");


        Thread.sleep(9000);


        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button")).click();


        Thread.sleep(1000);


        String ExpectedCreateMsg = "ACCOUNT CREATED!";
        String ActualCreateMsg = driver.findElement(By.xpath("//b")).getText();

        Assert.assertTrue(ExpectedCreateMsg.contains(ActualCreateMsg));


        // click on continue button after account created
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();


        //click on delete account
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();

        String ExpectedDeleteMsg = "ACCOUNT DELETED!" ;
        String ActualDeleteMsg = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText();
        Assert.assertTrue(ExpectedDeleteMsg.contains(ActualDeleteMsg));





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
