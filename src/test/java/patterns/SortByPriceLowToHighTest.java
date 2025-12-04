package patterns;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SortByPriceLowToHighTest extends BaseTest {

    @Test
    public void testSortByPriceLowToHigh() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.sortByPriceLowToHigh();

        Assert.assertTrue(inventoryPage.isSortedByPriceLowToHigh());
    }
}
