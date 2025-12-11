package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RemoveFromCartTest extends BaseTest {

    @Test
    public void testRemoveButton() {

        login();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        By addToCartButton = By.cssSelector("button[data-test='add-to-cart-sauce-labs-backpack']");
        By removeFromCartButton = By.cssSelector("button[data-test='remove-sauce-labs-backpack']");
        By cartBadge = By.cssSelector("span[data-test = 'shopping-cart-badge']");

        driver.findElement(addToCartButton).click();
        driver.findElement(removeFromCartButton).click();

        boolean badge = wait.until(ExpectedConditions.invisibilityOfElementLocated(cartBadge));

        Assert.assertTrue(badge);
    }
}
