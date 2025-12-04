package patterns;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveItemFromCartTest extends BaseTest {

    @Test
    public void testRemoveItemFromCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");

        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();
        cartPage.removeProductFromCart("Sauce Labs Backpack");

        Assert.assertFalse(cartPage.isProductInCart("Sauce Labs Backpack"));
    }
}
