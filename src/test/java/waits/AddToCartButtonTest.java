package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartButtonTest extends BaseTest {

    @Test
    public void testAddToCartButton() {
        login();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        By addToCartButton = By.cssSelector("button[data-test='add-to-cart-sauce-labs-backpack']");
        By removeButton   = By.cssSelector("button[data-test='remove-sauce-labs-backpack']");

        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();

        String removeText = driver.findElement(removeButton).getText();

        Assert.assertEquals(removeText, "Remove");
    }
}
