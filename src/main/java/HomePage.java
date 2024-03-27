import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebElement loginMsg (WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b"));
    }

    public WebElement LogoutButton(WebDriver driver)
    {
        return driver.findElement(By.xpath("//a[@href=\"/logout\"]"));
    }


    public WebElement ProductsButton(WebDriver driver)
    {
        return driver.findElement(By.xpath("//a[@href=\"/products\"]"));
    }
}
