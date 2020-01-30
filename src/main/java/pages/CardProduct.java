package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardProduct extends BasicPage {
    @FindBy(xpath = "//select[@class='form-control select']")
    public WebElement garanty;
    @FindBy(xpath = "//button[@class='btn btn-cart btn-lg']")
    public WebElement button;

    public CardProduct(WebDriver driver) {
        super(driver);
    }

    public int getPrice() {
        return Integer.parseInt(price.getText().replaceAll("\\s", ""));
    }

    public void setGaranty(WebDriver driver) {
        garanty.click();
        driver.findElement(By.xpath("//option[@value='2']")).click();
    }
}
