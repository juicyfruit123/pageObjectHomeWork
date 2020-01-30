package pages;

import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bucket extends BasicPage {
    @FindBy(xpath = "//span[contains(text(),'Добавить дополнительную гарантию')]")
    private WebElement garanty;
    @FindBy(xpath = "//div[contains(text(),'Дополнительная гарантия 2 года')]/..//button")
    public WebElement addGarantyButton;
    @FindBy(xpath = "//div[@class='list-applied-product-services__item']")
    public WebElement garantyHaveIcon;
    @FindBy(xpath = "//span[@class='cart-link__price']")
    public WebElement productAmount;
    @FindBy(xpath = "//span[@class='restore-last-removed']")
    private WebElement restoreElement;


    public Bucket(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    public void addGaranty() {
        productAmount.click();
        garanty.click();
        addGarantyButton.click();
    }

    public int getProductAmount() {
        return Integer.parseInt(productAmount.getText().replaceAll("\\s", ""));
    }

    public void countMinusElement(Product product, WebDriver driver, int count) {
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),\'" + product.getDescription() + "\')]/../../../..//button[@class='count-buttons__button count-buttons__button_minus']"));
        for (int i = 0; i < count; i++) {
            element.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void countPlusElement(Product product, WebDriver driver, int count) {
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),\'" + product.getDescription() + "\')]/../../../..//button[@class='count-buttons__button count-buttons__button_plus']"));

        for (int i = 0; i < count; i++) {
            element.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void restoreElement() {
        restoreElement.click();
    }
}



