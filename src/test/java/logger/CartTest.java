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

public class CartTest {

    private WebDriver driver;
    private final Logger logger = LogManager.getLogger(CartTest.class);

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

    public void  addItemToCart() {
        try {
            driver.get("https://www.saucedemo.com/");

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            logger.info("Product added to cart");

            driver.findElement(By.className("shopping_cart_link")).click();
            logger.info("Navigated to cart page");
        } catch (Exception e) {
            logger.error("Error while adding item to cart", e);
            throw e;
        }
    }

    @Test
    public void cartTest() {
        try {
            addItemToCart();

            boolean isItemDisplayed = driver.findElement(By.className("cart_item")).isDisplayed();
            Assert.assertTrue(isItemDisplayed);
            logger.info("Item successfully added to cart");
        } catch (AssertionError e) {
            logger.error("Cart verification failed");
            throw e;
        }
    }
}
