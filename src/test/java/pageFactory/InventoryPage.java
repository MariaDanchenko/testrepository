package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartLink;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    public InventoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addFirstProductToCart() {
        addToCartButton.click();
    }

    public void openCart() {
        cartLink.click();
    }

    public String getCartBadgeValue() {
        return cartBadge.getText();
    }
}
