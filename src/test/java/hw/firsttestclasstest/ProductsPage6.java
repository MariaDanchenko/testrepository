package hw.firsttestclasstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage6 extends BasePage3 {

    private final By productsList = By.className("inventory_list");

    public ProductsPage6(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsListDisplayed() {
        return driver.findElement(productsList).isDisplayed();
    }
}
