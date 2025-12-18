package pageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseTest {

    @Test
    public void testInventoryPage() {
        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.addFirstProductToCart();
        inventoryPage.openCart();

        Assert.assertEquals(inventoryPage.getCartBadgeValue(), "1");
    }
}
