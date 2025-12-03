package patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private final By countOfCart = By.cssSelector(".shopping_cart_badge");
    private final By shoppingCartLink = By.cssSelector("[data-test = 'shopping-cart-link']");
    private final By removeButton = By.cssSelector("button[data-test^ = 'remove-']");
    private final By checkoutButton = By.cssSelector("button[data-test = 'checkout']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        driver.findElement(shoppingCartLink).click();
    }

    public int getCartItemCount() {
        String countText = driver.findElement(countOfCart).getText();
        return Integer.parseInt(countText);
    }

    public void removeProduct() {
        driver.findElement(removeButton).click();
    }

    public void checkout() {
        driver.findElement(checkoutButton).click();
    }
}
