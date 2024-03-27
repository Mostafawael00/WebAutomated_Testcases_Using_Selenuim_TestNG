import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {


    public WebElement LoginURL_Msg (WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
    }

    public WebElement EmailField (WebDriver driver)
    {
        return  driver.findElement(By.xpath("//input[@data-qa=\"login-email\"]"));
    }

    public WebElement PasswordField  (WebDriver driver)
    {
        return driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]"));
    }

    public WebElement LoginButton (WebDriver driver)
    {
        return driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]"));
    }



    public WebElement unLogMsg (WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"));
    }
}
