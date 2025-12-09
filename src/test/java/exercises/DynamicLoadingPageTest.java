package exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicLoadingPageTest {

    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }

    @BeforeMethod
    public void openPage() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
    }

    @Test
    public void testExampleOne() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.openExampleOne();
        dynamicLoadingPage.clickStart();

        Assert.assertEquals(dynamicLoadingPage.waitForText(), "Hello World!");
    }

    @Test
    public void testExampleTwo() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.openExampleTwo();
        dynamicLoadingPage.clickStart();

        Assert.assertEquals(dynamicLoadingPage.waitForText(), "Hello World!");
    }
}
