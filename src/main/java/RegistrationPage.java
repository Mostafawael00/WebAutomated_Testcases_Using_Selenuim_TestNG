import io.opentelemetry.context.internal.shaded.WeakConcurrentMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

    public WebElement SignupButton(WebDriver driver)
    {
        return driver.findElement(By.xpath("//a[@href=\"/login\"]"));
    }

    public WebElement NameField(WebDriver driver)
    {
       return driver.findElement(By.xpath("//input[@type=\"text\"]"));
    }

    public WebElement EmailField(WebDriver driver)
    {
        return driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]"));
    }

    public WebElement SignupButton2(WebDriver driver)
    {
        return driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]"));
    }

    public WebElement RegistrationMsg (WebDriver driver)
    {
        return driver.findElement(By.xpath("//b"));
    }

    public WebElement GenderField (WebDriver driver)
    {
        return  driver.findElement(By.id("id_gender1"));
    }
    public WebElement PasswordField (WebDriver driver)
    {
        return  driver.findElement(By.id("password"));
    }

    public WebElement DaySelect (WebDriver driver)
    {
        return  driver.findElement(By.id("days"));
    }
    public WebElement MonthSelect (WebDriver driver)
    {
        return  driver.findElement(By.id("months"));
    }
    public WebElement YearSelect (WebDriver driver)
    {
        return  driver.findElement(By.id("years"));
    }

    public WebElement NewsLetterCheckBox (WebDriver driver)
    {
        return driver.findElement(By.id("newsletter"));
    }

    public WebElement OptionCheckBox (WebDriver driver)
    {
        return  driver.findElement(By.id("optin"));
    }

    public WebElement FirstNameField (WebDriver driver)
    {
        return  driver.findElement(By.xpath("//input[@data-qa=\"first_name\"]"));
    }

    public WebElement LastNameField (WebDriver driver)
    {
        return  driver.findElement(By.xpath("//input[@data-qa=\"last_name\"]"));
    }

    public WebElement CompanyField (WebDriver driver)
    {
        return driver.findElement(By.xpath("//input[@data-qa=\"company\"]"));
    }

    public WebElement AddressField (WebDriver driver)
    {
        return driver.findElement(By.xpath("//input[@data-qa=\"address\"]"));
    }

    public WebElement StateField (WebDriver driver)
    {
        return driver.findElement(By.xpath("//input[@data-qa=\"state\"]"));
    }

    public WebElement CityField (WebDriver driver)
    {
        return driver.findElement(By.xpath("//input[@data-qa=\"city\"]"));
    }

    public WebElement ZipcodeField (WebDriver driver)
    {
        return driver.findElement(By.xpath("//input[@data-qa=\"zipcode\"]"));
    }

    public WebElement MobileNumberField  (WebDriver driver)
    {
        return driver.findElement(By.xpath("//input[@data-qa=\"mobile_number\"]"));
    }

    public WebElement CreateAccountButton (WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button"));
    }

    public WebElement CreateAccMsg (WebDriver driver)
    {
        return driver.findElement(By.xpath("//b"));
    }


    public WebElement ContinueButton (WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
    }

    public WebElement DeleteAccButton (WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
    }
    public WebElement DeletdAccMsg (WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
    }

    public WebElement EmailExisingMsg (WebDriver driver)
    {
        return driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/p"));

    }
    public WebElement SignupMsg (WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
    }

}
