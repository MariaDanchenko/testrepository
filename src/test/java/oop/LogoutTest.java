package oop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    void testLogout() {

        login();

        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.logout();

        By loginButton = By.cssSelector("#login-button");
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());
    }
}
