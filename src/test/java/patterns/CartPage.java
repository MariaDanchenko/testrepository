package patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    private final By countOfCart = By.cssSelector(".shopping_cart_badge");
    private final By shoppingCartLink = By.cssSelector("[data-test = 'shopping-cart-link']");
    private final By removeButton = By.cssSelector("button[data-test^='remove-']");
    private final By checkoutButton = By.cssSelector("button[data-test = 'checkout']");
    private final By cartList = By.cssSelector(".cart_item");
    private final By itemName = By.cssSelector(".inventory_item_name");

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

    public void removeProductFromCart(String nameOfProduct) {
        List<WebElement> items = driver.findElements(cartList);//получаем список

        for (int i = 0; i < items.size(); i++) {
            WebElement item = items.get(i);
            String name = item.findElement(itemName).getText();//получаем название
            if (name.equals(nameOfProduct)) {
                item.findElement(removeButton).click();
                break;
            }
        }
    }

    public boolean isProductInCart(String nameOfProduct) {
        List<WebElement> items = driver.findElements(cartList);

        for (int i = 0; i < items.size(); i++) {
            WebElement item = items.get(i);
            String name = item.findElement(itemName).getText();
            if (name.equals(nameOfProduct)) {
                return true;
            }
        }
        return false;
    }

    public void checkout() {
        driver.findElement(checkoutButton).click();
    }
}
