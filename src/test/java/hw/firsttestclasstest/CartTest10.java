package hw.firsttestclasstest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest10 {

    private WebDriver driver;
    private LoginPage5 loginPage;
    private ProductsPage8 productsPage;
    private CartPage9 cartPage;

    @BeforeClass
    void addProductsToCart() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage5(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage = new ProductsPage8(driver);
    }

    @AfterClass(alwaysRun = true)
    void closeDriver() {

        driver.quit();
    }

    @Test
    void firstTest() {

        productsPage.addToCart();
        int count = productsPage.getCartCount();
        Assert.assertEquals(count, 1);

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='shopping_cart_container']/a"))).click();

        cartPage = new CartPage9(driver);

        Assert.assertTrue(cartPage.waitUntilProductAppearedInCart().isDisplayed());
    }
}