package hw.firsttestclasstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage8 extends BasePage3 {

    private final By productsList = By.xpath("//div[contains(@class, 'inventory_list')]");
    private final By addToCartButton = By.cssSelector(".inventory_item button.btn_inventory");
    private final By cartBadge = By.xpath("//div[@id='shopping_cart_container']/a");

    public ProductsPage8(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsListDisplayed() {
        return driver.findElement(productsList).isDisplayed();
    }

    public void addToCart() {
        driver.findElements(addToCartButton).get(0).click();
    }

    public int getCartCount() {
        String badgeText = driver.findElement(cartBadge).getText();
        return Integer.parseInt(badgeText);
    }
}
