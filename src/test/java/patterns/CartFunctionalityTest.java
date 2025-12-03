package patterns;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartFunctionalityTest extends BaseTest{

    @Test
    public void testCartFunctionality() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");

        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();

        Assert.assertEquals(cartPage.getCartItemCount(), 1);
    }
}
