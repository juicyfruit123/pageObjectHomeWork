package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResult extends BasicPage {

    private By element = By.xpath("//div[@class='product-info__title-link']/a");

    public SearchResult(WebDriver driver) {
        super(driver);
    }

    public int getPrice() {
        return Integer.parseInt(price.getText().replaceAll("\\s", ""));
    }

    public WebElement clickOnProduct(String product, WebDriver driver) {
        List<WebElement> goods = driver.findElements(element);
        for (WebElement e : goods) {
            if (e.getText().contains(product)) {
                return e;
            }
        }
        return goods.get(0);
    }
}
