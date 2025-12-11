package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ProductsVisibleTest extends BaseTest {

    @Test
    public void testProductsAreVisible() {

        login();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        By inventoryList = By.cssSelector(".inventory_list");
        By products = By.cssSelector(".inventory_item");

        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryList));

        List<WebElement> productElements = driver.findElements(products);
        Assert.assertTrue(productElements.size() > 0);
    }
}
