package pages;

import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasicPage {
    @FindBy(xpath = "//div[@class='clearfix']//span[@class='current-price-value']")
    public WebElement price;

    public BasicPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public Boolean isElementPresented(Product product, WebDriver driver) {
        boolean notExist;
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            notExist = driver.findElement(By.xpath("//a[contains(text(),\'" + product.getDescription() + "\')]")).isDisplayed();

        } catch (NoSuchElementException e) {
            notExist = false;
        } finally {
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }

        return notExist;
    }

}
