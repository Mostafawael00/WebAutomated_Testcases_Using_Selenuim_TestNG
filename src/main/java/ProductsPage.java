import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

    public WebElement SearchField (WebDriver driver)
    {
        return driver.findElement(By.id("search_product"));
    }

    public WebElement SearchButton (WebDriver driver)
    {
        return driver.findElement(By.id("submit_search"));
    }

    public WebElement SearchMsg (WebDriver driver)
    {
        return driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/h2"));
    }

    public WebElement AddProduct1(WebDriver driver)
    {
        return driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a"));
    }

    public WebElement ContinueButton (WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button"));
    }

    public WebElement AddProduct2(WebDriver driver)
    {
        return driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a"));
    }

    public WebElement ViewCartButton (WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a"));
    }

    public WebElement AddProduct3(WebDriver driver)
    {
        return driver.findElement(By.xpath("//a[@href=\"/product_details/4\"]"));
    }

    public WebElement ClearQuantity (WebDriver driver)
    {
        return driver.findElement(By.id("quantity"));
    }

    public WebElement SetQuantity (WebDriver driver)
    {
        return driver.findElement(By.id("quantity"));
    }

    public WebElement AddToCart (WebDriver driver)
    {
        return driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button"));
    }




}
