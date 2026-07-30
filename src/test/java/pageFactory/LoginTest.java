package pageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginPage() {
        ProductPage productPage = new ProductPage(driver);

        Assert.assertTrue(productPage.isProductsTitleDisplayed());
        Assert.assertEquals(productPage.getTitleText(), "Products");
    }
}
