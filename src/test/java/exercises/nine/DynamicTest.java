package exercises.nine;

import exercises.eight.DynamicLoadingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(DynamicTest.class);

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        logger.info("Browser started");

        dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }

    @Test
    public void testDynamicLoadingPage() {
        dynamicLoadingPage.clickLink();
        logger.info("Clicked on the link");

        dynamicLoadingPage.clickStartButton();
        logger.info("Clicked on the Start button");

        Assert.assertEquals(dynamicLoadingPage.getLoadingMessage(), "Hello World!");
        logger.info("Successful loading");
    }
}

