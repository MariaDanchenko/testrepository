package pageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutPageTest extends BaseTest {

    @Test
    public void testCheckoutPage() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstProductToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutForm("Maria", "Danchenko" , "1234");

        Assert.assertEquals(checkoutPage.getTitleCheckout(), "Checkout: Overview");
    }
}
