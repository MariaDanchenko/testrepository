package patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {

    private WebDriver driver;

    private final By inventoryItems = By.cssSelector(".inventory_item");
    private final By itemName = By.cssSelector(".inventory_item_name");
    private final By addToCartButton = By.tagName("button");
    private final By shoppingCartBadge = By.cssSelector(".shopping_cart_badge");
    private final By shoppingCartLink = By.cssSelector("[data-test = 'shopping-cart-link']");
    private final By sortContainer = By.cssSelector("")

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getInventoryList() {
        return driver.findElements(inventoryItems);
    }

    public void addProductToCart(String nameOfProduct) {
        List<WebElement> items = driver.findElements(inventoryItems);

        for (int i = 0; i < items.size(); i++) {
            WebElement item = items.get(i);
            String name = item.findElement(itemName).getText();
            if (name.equals(nameOfProduct)) {
                item.findElement(addToCartButton).click();
                break;
            }
        }
    }

    public boolean isProductInCart(String nameOfProduct) {
        return !driver.findElements(shoppingCartBadge).isEmpty();
    }

    public void goToCart() {
        driver.findElement(shoppingCartLink).click();
    }

    public void sortByPriceLowToHigh() {

    }
}
