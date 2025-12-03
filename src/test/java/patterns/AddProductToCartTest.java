package patterns;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCartTest extends BaseTest {

    @Test
    public void testAddProductToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");

        Assert.assertTrue(inventoryPage.isProductInCart("Sauce Labs Backpack"));
    }
}
