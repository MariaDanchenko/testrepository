package logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    private final Logger logger = LogManager.getLogger(LoginTest.class);

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        logger.info("Browser started");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }

    public void loginToSauceDemo(String username, String password) {

        try {
            driver.get("https://www.saucedemo.com/");
            logger.info("Navigated to authorization page");

            driver.findElement(By.id("user-name")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            logger.info("Entering login and password");

            driver.findElement(By.id("login-button")).click();
            logger.info("Clicking the Login button");
        } catch (Exception e) {
            logger.error("Error during authorization", e);
        }
    }

    @Test
    public void loginTest() {
        try {
            loginToSauceDemo("standard_user", "secret_sauce");

            boolean isProductsTitleDisplayed = driver.findElement(By.cssSelector(".title")).isDisplayed();
            logger.info("Verifying successful login");

            Assert.assertTrue(isProductsTitleDisplayed);
            Assert.assertEquals(driver.findElement(By.cssSelector(".title")).getText(), "Products");
            logger.info("Successful login");
        } catch (AssertionError e) {
            logger.error("Authorization check error", e);
        }
    }
}
