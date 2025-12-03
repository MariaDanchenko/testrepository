package patterns;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutProcessTest extends BaseTest {

    @Test
    public void testCheckoutProcess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");

        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();
        cartPage.checkout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutForm("John", "Doe", "12345");
        checkoutPage.continueCheckout();

        Assert.assertTrue(checkoutPage.isCheckoutSummaryDisplayed());
    }
}
