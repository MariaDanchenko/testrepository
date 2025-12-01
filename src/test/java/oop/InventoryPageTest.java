package oop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InventoryPageTest {

    protected WebDriver driver;

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
    void testInventoryPage() {
        InventoryPage inventoryPage = new InventoryPage(driver);

        String title = inventoryPage.getPageTitle();

        Assert.assertEquals(title, "Swag Labs");
    }
}
