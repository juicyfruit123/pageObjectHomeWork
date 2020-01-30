package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search extends BasicPage {
    @FindBy(xpath = "//div[@class='container']//form[@action='/search/']/div/input")
    WebElement searchField;
    @FindBy(xpath = "//div[@class='container']//form[@action='/search/']/div/span[@class='ui-input-search__icon ui-input-search__icon_search ui-input-search__icon_presearch']")
    WebElement seach;

    public Search(WebDriver driver) {
        super(driver);
    }

    public SearchResult searchProduct(String str, WebDriver driver) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        searchField.sendKeys(str);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        seach.click();
        return new SearchResult(driver);
    }
}
