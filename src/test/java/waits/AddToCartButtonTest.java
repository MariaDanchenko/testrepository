package waits;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartButtonTest extends BaseTest {

    @Test
    public void testAddToCartButton() {
        login();

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickAddToCartButton();

        Assert.assertEquals(inventoryPage.getRemoveButtonText(), "Remove");
    }
}
