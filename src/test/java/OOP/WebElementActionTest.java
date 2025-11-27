package OOP;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebElementActionTest {

    private WebDriver driver;

    @BeforeClass
    void openSite() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass(alwaysRun = true)
    void closeDriver() {

        driver.quit();
    }

    @Test
    void testClickLoginButton() {
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");

        WebElementAction clickLogin = new ClickAction(By.cssSelector("#login-button"));
        clickLogin.performAction(driver);

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https://www.saucedemo.com/inventory.html"));
    }
}
