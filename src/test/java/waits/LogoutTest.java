package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogoutButton() {
        login();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        By burgerMenuButton = By.cssSelector("#react-burger-menu-btn");
        By logoutButton = By.cssSelector("#logout_sidebar_link");

        driver.findElement(burgerMenuButton).click();

        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));

        Assert.assertTrue(logout.isDisplayed());
    }
}
