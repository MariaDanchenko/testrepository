package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTest extends BaseTest {

    @Test
    public void testAddToCart() {
        login();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        By addToCartButton = By.cssSelector("button[data-test='add-to-cart-sauce-labs-backpack']");
        By cartBadge = By.cssSelector("span[data-test = 'shopping-cart-badge']");

        driver.findElement(addToCartButton).click();

        WebElement badge = wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartBadge));

        Assert.assertTrue(badge.isDisplayed());
        Assert.assertEquals(badge.getText(), "1");
    }
}
