package patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryPage {

    private WebDriver driver;

    private final By inventoryItems = By.cssSelector(".inventory_item");
    private final By itemName = By.cssSelector(".inventory_item_name");
    private final By addToCartButton = By.tagName("button");
    private final By shoppingCartBadge = By.cssSelector(".shopping_cart_badge");
    private final By shoppingCartLink = By.cssSelector("[data-test = 'shopping-cart-link']");
    private final By sortContainer = By.cssSelector(".product_sort_container");
    private final By lowToHigh = By.cssSelector("option[value = 'lohi']");
    private final By menuButton = By.cssSelector("#react-burger-menu-btn");
    private final By logoutButton = By.cssSelector("#logout_sidebar_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(String nameOfProduct) {
        List<WebElement> items = driver.findElements(inventoryItems); //получаем список товаров

        for (int i = 0; i < items.size(); i++) {
            WebElement item = items.get(i);
            String name = item.findElement(itemName).getText(); //получаем название товара
            if (name.equals(nameOfProduct)) { //сравниваем название
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
        driver.findElement(sortContainer).click();
        driver.findElement(lowToHigh).click();
    }

    public boolean isSortedByPriceLowToHigh() {
        List<WebElement> items = driver.findElements(inventoryItems);

        List<Double> prices = new java.util.ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            WebElement item = items.get(i);
            String priceText = item.findElement(By.cssSelector(".inventory_item_price")).getText(); //находим цену
            priceText = priceText.replace("$", ""); //убираем знак доллара
            prices.add(Double.parseDouble(priceText)); //преобразуем в число
        }

        List<Double> sorted = new ArrayList<>(prices); //копируем
        Collections.sort(sorted); //сортируем по возрастанию

        return prices.equals(sorted);
    }

    public void logout() {

        driver.findElement(menuButton).click();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(logoutButton));

        driver.findElement(logoutButton).click();
    }
}
