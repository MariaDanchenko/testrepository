package hw.firsttestclasstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage7 extends BasePage3 {

    private final By productsList = By.className("inventory_list");
    private final By addToCartButton = By.cssSelector(".inventory_item button.btn_inventory");

    public ProductsPage7(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsListDisplayed() {
        return driver.findElement(productsList).isDisplayed();
    }

    public void addToCart() {
        driver.findElements(addToCartButton).get(0).click();
    }
}
