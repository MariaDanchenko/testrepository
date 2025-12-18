package pageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

    @Test
    public void removeProductFromCartTest() {
        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.addFirstProductToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.removeProduct(driver);

        Assert.assertFalse(inventoryPage.isCartBadgeDisplayed());
    }
}
