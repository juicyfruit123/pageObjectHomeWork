import model.Product;
import org.junit.Assert;
import org.junit.Test;
import pages.Bucket;
import pages.CardProduct;
import pages.Search;
import pages.SearchResult;

public class OurTest extends BaseTest {
    private Search search = new Search(driver);
    private SearchResult searchResult;
    private CardProduct cardProduct;
    private Bucket bucket;

    @Test
    public void Test() throws InterruptedException {
        //Ищем и кликаем на Playstation
        searchResult = search.searchProduct("playstation", driver);
        searchResult.clickOnProduct("PlayStation 4 Slim Black", driver).click();
        cardProduct = new CardProduct(driver);
        //Цена PlayStation
        int price = cardProduct.getPrice();
        cardProduct.setGaranty(driver);
        cardProduct.button.click();
        //Цена с гарантией
        int priceWithGaranty = cardProduct.getPrice();

        Product playStation = new Product(price, priceWithGaranty - price, "PlayStation");
        //Добавление гарантии к продукту в корзине
        bucket = new Bucket(driver);
        bucket.addGaranty();
        //Поиск Detroit
        searchResult = search.searchProduct("Detroit", driver);
        //Цена Detroit
        int priceDetroit = searchResult.getPrice();
        Product detroit = new Product(priceDetroit, 0, "Detroit");

        cardProduct = new CardProduct(driver);
        //Нажать купить
        cardProduct.button.click();
        Thread.sleep(5000);
        //Переход в корзину
        bucket.productAmount.click();
        //Проверка что цена корзины стала равна сумме покупок
        Assert.assertEquals(detroit.getPrice() + playStation.getPrice(), bucket.getProductAmount());
        //Проверка что для приставки выбрана гарантия 2 года
        Assert.assertTrue(bucket.garantyHaveIcon.getText().contains("гарантия на 24 мес."));
        //Проверка цены каждого из товатов и суммы
        Assert.assertEquals(playStation.getPrice() + detroit.getPrice(), bucket.getProductAmount());
        //Цена корзины
        int allPrice = bucket.getProductAmount();
        //Удаление Detroit
        bucket.countMinusElement(detroit, driver, 1);
        Thread.sleep(5000);
        //Проверка что Detroit нет больше в корзине
        Assert.assertFalse(bucket.isElementPresented(detroit, driver));
        //Проверка что цена уменьшилась
        Assert.assertEquals(allPrice - detroit.getPrice(), bucket.getProductAmount());
        //Добавление двух PlayStation
        bucket.countPlusElement(playStation, driver, 2);
        //Проверка что сумма равна
        Assert.assertEquals(playStation.getPrice() * 3, bucket.getProductAmount());
        //Цена до восстановления удаленного элемента
        int allPriceBeforeRestore = bucket.getProductAmount();
        //Восстановление удаленного элемента
        bucket.restoreElement();
        Thread.sleep(3000);
        //Проверка что Detroit вернулся в корзину
        Assert.assertTrue(bucket.isElementPresented(detroit, driver));
        //Проверка что сумма увеличилась на цену Detroit
        Assert.assertEquals(allPriceBeforeRestore + detroit.getPrice(), bucket.getProductAmount());
    }
}
