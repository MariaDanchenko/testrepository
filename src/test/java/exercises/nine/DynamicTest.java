package exercises.nine;

import exercises.eight.DynamicLoadingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomTestListener.class)
public class DynamicTest {

    private WebDriver driver;
    private exercises.eight.DynamicLoadingPage dynamicLoadingPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testDynamicLoadingPage() {
        dynamicLoadingPage.clickLink();

        dynamicLoadingPage.clickStartButton();

        Assert.assertEquals(dynamicLoadingPage.getLoadingMessage(), "Hello World!");
    }
}

