import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    public WebElement Product1Displayed (WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[6]/a"));
    }

    public WebElement Product2Displayed (WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[6]/a"));
    }

    public WebElement DeleteProduct1 (WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[6]/a"));
    }
    public WebElement DeleteProduct2 (WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[6]/a"));
    }

    public WebElement CartEmptyMsg (WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"empty_cart\"]/p"));
    }

    public WebElement Quantity (WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"product-4\"]/td[4]/button"));
    }




}
