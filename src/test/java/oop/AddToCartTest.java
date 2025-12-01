package oop;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    void testAddToCart() {

        login();

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart();

        Assert.assertEquals(inventoryPage.getCartBadge(), "1");
    }
}
