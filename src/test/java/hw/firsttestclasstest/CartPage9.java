package hw.firsttestclasstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IExpectedExceptionsHolder;

import java.time.Duration;

public class CartPage9 extends BasePage3 {

    private final By cartItem = By.xpath("//div[contains(@class, 'cart_item_label')]");
    private WebDriverWait  webDriverWait;

    public CartPage9(WebDriver driver) {
        super(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement waitUntilProductAppearedInCart() {

        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(cartItem));
    }
}
