package logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutTest {

    private WebDriver driver;
    private final Logger logger = LogManager.getLogger(CheckoutTest.class);

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void checkoutProcess() {
            driver.get("https://www.saucedemo.com/");

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            logger.info("Authorization");

            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            logger.info("Product added to cart");

            driver.findElement(By.className("shopping_cart_link")).click();
            logger.info("Navigated to cart page");

            driver.findElement(By.id("checkout")).click();
            logger.info("Start checkout");

            driver.findElement(By.id("first-name")).sendKeys("John");
            driver.findElement(By.id("last-name")).sendKeys("Doe");
            driver.findElement(By.id("postal-code")).sendKeys("12345");
            logger.info("Filled out the form");

            driver.findElement(By.id("continue")).click();
            logger.info("Proceed to overview");

            driver.findElement(By.id("finish")).click();
            logger.info("Finish checkout");
    }

    @Test
    public void checkoutTest() {
        try {
            checkoutProcess();

            String title = driver.findElement(By.className("title")).getText();

            Assert.assertEquals(title, "Checkout: Complete!");
            logger.info("Checkout completed successfully");
        } catch (Exception e) {
            logger.info("Checkout test failed", e);
        }
    }
}
